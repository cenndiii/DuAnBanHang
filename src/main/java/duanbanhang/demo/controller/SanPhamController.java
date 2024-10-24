package duanbanhang.demo.controller;

import duanbanhang.demo.model.DanhMuc;
import duanbanhang.demo.model.SanPham;
import duanbanhang.demo.repository.DanhMucRepo;
import duanbanhang.demo.repository.SanPhamRepo;
import duanbanhang.demo.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;

    SanPham sanPham = new SanPham(null,"","","Active",null,null,null);

    @GetMapping("/hien-thi")
    public String hienThi(Model m ){
        sanPhamService.getData();
        m.addAttribute("listSanPham",sanPhamService.listSanPham);
        m.addAttribute("listDanhMuc",sanPhamService.listDanhMuc);
        m.addAttribute("sanPham",sanPham);
        return "sanPham";
    }


    @PostMapping("/add-sanPham")
    public String addDm(@Valid @ModelAttribute SanPham d, BindingResult b, Model model) {
        if (b.hasErrors()){
            model.addAttribute("listSanPham",sanPhamService.listSanPham);
            model.addAttribute("listDanhMuc",sanPhamService.listDanhMuc);
            model.addAttribute("sanPham",d);
            return "sanPham";
        }
        sanPhamService.addSanPham(d);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/detail-sanPham/{id}")
    public String sizeDetail(@PathVariable Long id, Model model) {
        sanPhamService.getData();
        model.addAttribute("sanPham", sanPhamService.sanPhamDetail(id));
        model.addAttribute("listDanhMuc",sanPhamService.listDanhMuc);
        return "sanPhamDetail";
    }

    @PostMapping("/update-sanPham/{id}")
    public String updateSize(@PathVariable Long id,@Valid @ModelAttribute SanPham s,BindingResult b,Model model) {
        if (b.hasErrors()){
            sanPhamService.getData();
            model.addAttribute("listDanhMuc",sanPhamService.listDanhMuc);
            return "sanPhamDetail";
        }
        sanPhamService.updateSanPham(id,s);
        return "redirect:/san-pham/hien-thi";
    }
}
