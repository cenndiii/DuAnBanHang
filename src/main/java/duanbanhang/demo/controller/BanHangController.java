package duanbanhang.demo.controller;

import duanbanhang.demo.model.Ctsp;
import duanbanhang.demo.model.GioHang;
import duanbanhang.demo.model.Hdct;
import duanbanhang.demo.model.HoaDon;
import duanbanhang.demo.repository.ChiTietSpRepo;
import duanbanhang.demo.repository.HdctRepo;
import duanbanhang.demo.repository.HoaDonRepo;
import duanbanhang.demo.repository.KhachHangRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ban-hang")
public class BanHangController {
    List<GioHang> listGioHang = new ArrayList<>();
    @Autowired
    ChiTietSpRepo chiTietSpRepo;

    @Autowired
    HoaDonRepo hoaDonRepo;

    @Autowired
    KhachHangRepo khachHangRepo;

    @Autowired
    HdctRepo hdctRepo;

    BigDecimal total = BigDecimal.ZERO;
    String error;
    private List<Ctsp> listCtsp;
    private List<Ctsp> listCtspCopy;
    private HoaDon hdD = null;

    @PostConstruct
    public void init() {

        try {
            listCtsp = chiTietSpRepo.findAll();
            listCtspCopy = chiTietSpRepo.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/hien-thi")
    public String hienThi(Model m) {
        m.addAttribute("listCtsp", listCtsp);
        m.addAttribute("listCart", listGioHang);
        m.addAttribute("listHoaDon", hoaDonRepo.findAllByTrangThai("Cho thanh toan"));
        m.addAttribute("listKhachHang", khachHangRepo.findByTrangThai("Active"));
        m.addAttribute("total", total);
        m.addAttribute("hoaDon", hdD);
        m.addAttribute("error", error);
        return "banHang";
    }

    @PostMapping("/getSoLuong")
    public String getSl(@RequestParam("soLuongMua") String slStrg, @RequestParam("id") Long id) {
        boolean check = false;

        if (hdD == null) {
            error = "Chua chon hd";
            return "redirect:/ban-hang/hien-thi";
        }
        int sl = 0;
        // Validate số lượng phải là số nguyên
        try {
            sl = Integer.parseInt(slStrg);
        } catch (NumberFormatException e) {
            error = "So luong khong phai so nguyen!";
            return "redirect:/ban-hang/hien-thi";
        }

        // Validate sl > 0
        if (sl <= 0) {
            error = "So luong phai lon hon 0";
            return "redirect:/ban-hang/hien-thi";
        }

        error = "";
        for (Ctsp c : listCtsp) {
            if (c.getId().equals(id)) {
                if (sl > c.getSoLuongTon()) {
                    error = "Khong duoc nhap qua sl ton";
                    return "redirect:/ban-hang/hien-thi";
                }
                GioHang gh = new GioHang(c.getId(), c.getSanPham().getTenSanPham(), c.getMauSac().getTenMau(), c.getSize().getTenSize(), c.getGiaBan(), sl);
                for (GioHang g : listGioHang) {
                    if (g.getId().equals(gh.getId())) {
                        g.setSoLuong(g.getSoLuong() + gh.getSoLuong());
                        c.setSoLuongTon(c.getSoLuongTon() - sl);
                        total = total.add(BigDecimal.valueOf(g.getSoLuong()).multiply(g.getGiaBan()));
                        check = true;
                    }
                }
                if (!check) {
                    c.setSoLuongTon(c.getSoLuongTon() - sl);
                    listGioHang.add(gh);
                    total = total.add(BigDecimal.valueOf(gh.getSoLuong()).multiply(gh.getGiaBan()));
                }
            }
        }

        return "redirect:/ban-hang/hien-thi";
    }

    @PostMapping("/sua-sl")
    public String suaSoluong(@RequestParam("soLuongMua") String slStrg, @RequestParam("id") Long id) {
        total = BigDecimal.ZERO;
        total = listGioHang.stream()
                .map(gh -> BigDecimal.valueOf(gh.getSoLuong()).multiply(gh.getGiaBan()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        int sl;
        try {
            sl = Integer.parseInt(slStrg);
        } catch (NumberFormatException e) {
            error = "So luong khong phai so nguyen!";
            return "redirect:/ban-hang/hien-thi";
        }
        if (sl <= 0) {
            error = "So luong phai lon hon 0";
            return "redirect:/ban-hang/hien-thi";
        }
        for (Ctsp ctsp : listCtspCopy){
            if (ctsp.getId().equals(id)){
                if (sl > ctsp.getSoLuongTon()) {
                    error = "Khong duoc nhap qua sl ton";
                    return "redirect:/ban-hang/hien-thi";
                }
            }
        }
        for (GioHang gh : listGioHang) {
            if (gh.getId().equals(id)) {
                for (Ctsp c : listCtsp) {
                    if (c.getId().equals(id)) {
                        c.setSoLuongTon(c.getSoLuongTon() + (gh.getSoLuong()) - sl);
                    }
                }
                gh.setSoLuong(sl);
            }
        }
        total = listGioHang.stream()
                .map(gh -> BigDecimal.valueOf(gh.getSoLuong()).multiply(gh.getGiaBan()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return "redirect:/ban-hang/hien-thi";
    }

    @GetMapping("/xoa-gioHang/{id}")
    public String xoaGh(@PathVariable Long id) {
        GioHang rGh = new GioHang();
        for (Ctsp c : listCtsp) {
            if (c.getId().equals(id)) {
                for (GioHang gh : listGioHang) {
                    if (gh.getId().equals(id)) {
                        c.setSoLuongTon(c.getSoLuongTon() + gh.getSoLuong());
                        rGh = gh;
                        total = total.subtract(BigDecimal.valueOf(gh.getSoLuong()).multiply(gh.getGiaBan()));
                    }
                }
            }
        }
        listGioHang.remove(rGh);
        return "redirect:/ban-hang/hien-thi";
    }

    @GetMapping("/add-hoaDon")
    public String addHd() {
        HoaDon hd = new HoaDon();
        hd.setTrangThai("Cho thanh toan");
        hd.setNgayTao(LocalDateTime.now());
        hoaDonRepo.save(hd);
        return "redirect:/ban-hang/hien-thi";
    }

    @PostMapping("/thanh-toan")
    public String thanhToan(@RequestParam("id") Long id, @ModelAttribute HoaDon hd) {
        if (id.equals(null)) {
            error = "chua chon hd de thanh toan";
            return "redirect:/ban-hang/hien-thi";
        }
        hd.setTrangThai("Da thanh toan");
        hd.setNgaySua(LocalDateTime.now());
        hoaDonRepo.save(hd);
        for (GioHang gh : listGioHang) {
            Hdct hdct = new Hdct();
            hdct.setHoaDon(hd);
            hdct.setCtsp(chiTietSpRepo.findById(gh.id).get());
            hdct.setSoLuongMua(gh.getSoLuong());
            hdct.setGiaBan(gh.getGiaBan());
            hdct.setTrangThai("Active");
            hdct.setTongTien(BigDecimal.valueOf(gh.getSoLuong()).multiply(gh.getGiaBan()));
            hdct.setNgayTao(LocalDateTime.now());
            hdctRepo.save(hdct);
        }
        chiTietSpRepo.saveAll(listCtsp);
        clearData();
        return "redirect:/ban-hang/hien-thi";
    }

    private void clearData() {
        listGioHang.clear();
        hdD = null;
        total = BigDecimal.ZERO;
    }

    @GetMapping("/chon-hd/{id}")
    public String chonHd(@PathVariable Long id) {
        hdD = hoaDonRepo.findById(id).get();
        listGioHang.clear();
        return "redirect:/ban-hang/hien-thi";
    }

    @GetMapping("/huy-hd/{id}")
    public String huyHd(@PathVariable Long id) {
        HoaDon h = hoaDonRepo.findById(id).orElse(null);
        if (h != null) {
            h.setTrangThai("Huy");
            hoaDonRepo.save(h);
            clearData();
        }
        return "redirect:/ban-hang/hien-thi";
    }
}
