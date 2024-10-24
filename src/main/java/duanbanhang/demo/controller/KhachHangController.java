package duanbanhang.demo.controller;


import duanbanhang.demo.model.KhachHang;
import duanbanhang.demo.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    KhachHang khachHang = new KhachHang(null, "", "", "", "Active", null, null);

    @GetMapping("/hien-thi")
    public String hienThi(Model m) {
        khachHangService.getData();
        m.addAttribute("listKhachHang", khachHangService.listKh);
        m.addAttribute("khachHang", khachHang);
        return "khachHang";
    }

    @PostMapping("/add-khachHang")
    public String addSp(@Valid @ModelAttribute KhachHang d, BindingResult b,Model m) {
        if (b.hasErrors()) {
            m.addAttribute("listKhachHang", khachHangService.listKh);
            m.addAttribute("khachHang", d);
            return "khachHang";
        }
        khachHangService.addKhachHang(d);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/detail-khachHang/{id}")
    public String sizeDetail(@PathVariable Long id, Model model) {
        model.addAttribute("khachHang",khachHangService.khahcHangDetail(id));
        return "khachHangDetail";
    }

    @PostMapping("/update-khachHang/{id}")
    public String updateSize(@PathVariable Long id,@Valid @ModelAttribute KhachHang s,BindingResult b) {
        if (b.hasErrors()){
            return "khachHangDetail";
        }
        khachHangService.updateKhachHang(id,s);
        return "redirect:/khach-hang/hien-thi";
    }
}
