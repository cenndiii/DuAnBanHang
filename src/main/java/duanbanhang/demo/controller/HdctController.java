package duanbanhang.demo.controller;

import duanbanhang.demo.model.HdView;
import duanbanhang.demo.model.Spct;
import duanbanhang.demo.repository.HdctRepo;
import duanbanhang.demo.repository.HoaDonRepo;
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
@RequestMapping("/hdct")
public class HdctController {
    @Autowired
    HdctRepo hdctRepo;

    @Autowired
    HoaDonRepo hoaDonRepo;
    BigDecimal totalBill = BigDecimal.ZERO;
    BigDecimal totalAllBill = BigDecimal.ZERO;
    private List<HdView> listHoaDon = new ArrayList<>();
    private List<Spct> listSpct = new ArrayList<>();

    @PostConstruct
    public void init() {

        try {
            listHoaDon = hoaDonRepo.listAllHd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("listHoaDon", listHoaDon);
        model.addAttribute("listSpct", listSpct);
        model.addAttribute("totalBill", totalBill);
        for (HdView hd : listHoaDon) {
            if (hd.getTongTien() != null) {
                totalAllBill = totalAllBill.add(hd.getTongTien());
            }
        }
        model.addAttribute("totalAllBill", totalAllBill);
        totalAllBill = BigDecimal.ZERO;
        totalBill = BigDecimal.ZERO;
        return "hdct";
    }

    @GetMapping("/detail-hdct/{id}")
    public String detailHd(@PathVariable Long id, Model model) {
        totalBill = BigDecimal.ZERO;
        listSpct = hdctRepo.listSpct(id);
        for (Spct s : listSpct) {
            totalBill = totalBill.add(s.getTongTien());
        }
        return "redirect:/hdct/hien-thi";
    }

    @GetMapping("/reload")
    public String reload() {
        listHoaDon = hoaDonRepo.listAllHd();
        listSpct = null;
        return "redirect:/hdct/hien-thi";
    }

    @PostMapping("/tim-kiem")
    public String timKiem(
            @RequestParam("keyWord") String kw,
            @RequestParam("key") int key,
            @RequestParam(value = "startDate", required = false) LocalDateTime startDate,
            @RequestParam(value = "endDate", required = false) LocalDateTime endDate,
            Model model // Thêm Model để truyền thông báo lỗi tới trang JSP
    ) {

        try {
            kw = kw.trim();
            if (!kw.isEmpty() && startDate == null && endDate == null) {
                switch (key) {
                    case 1 -> listHoaDon = hoaDonRepo.findAllById(Long.valueOf(kw));
                    case 2 -> listHoaDon = hoaDonRepo.findAllByKhachHang_Id(Long.valueOf(kw));
                    case 3 -> listHoaDon = hoaDonRepo.findAllByKhachHang_HoTenContains(kw);
                    case 4 -> listHoaDon = hoaDonRepo.findAllByTrangThaiContains(kw);
                    default -> throw new IllegalStateException("Giá trị không mong đợi: " + key);
                }
            } else if (kw.isEmpty()) {
                if (startDate != null && endDate == null) {
                    listHoaDon = hoaDonRepo.findAllByNgayTaoAfter(startDate);
                } else if (endDate != null && startDate == null) {
                    listHoaDon = hoaDonRepo.findAllByNgayTaoBefore(endDate);
                } else if (startDate != null && endDate != null) {
                    listHoaDon = hoaDonRepo.findAllByNgayTaoBetween(startDate, endDate);
                }
            } else if (!kw.isEmpty() && startDate != null && endDate != null) {
//                switch (key) {
//                    case 1 -> listHoaDon = hoaDonRepo.findAllByNgayTaoBetweenAndId(startDate, endDate, Long.valueOf(kw));
//                    case 2 -> listHoaDon = hoaDonRepo.findAllByNgayTaoBetweenAndKhachHang_Id(startDate, endDate, Long.valueOf(kw));
//                    case 3 -> listHoaDon = hoaDonRepo.findAllByNgayTaoBetweenAndKhachHang_HoTenContains(startDate, endDate, kw);
//                    case 4 -> listHoaDon = hoaDonRepo.findAllByNgayTaoBetweenAndTrangThaiContains(startDate, endDate, kw);
//                    default -> throw new IllegalStateException("Giá trị không mong đợi: " + key);
//                }
            }
        } catch (NumberFormatException e) {
            model.addAttribute("error", "ID và ID khách hàng phải là số. Vui lòng kiểm tra lại.");
            return "redirect:/hdct/hien-thi";
        } catch (IllegalStateException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/hdct/hien-thi";
        } catch (Exception e) {
            model.addAttribute("error", "Đã xảy ra lỗi không xác định. Vui lòng thử lại.");
            return "redirect:/hdct/hien-thi";
        }

        return "redirect:/hdct/hien-thi";
    }

}
