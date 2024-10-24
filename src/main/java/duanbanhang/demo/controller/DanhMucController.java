package duanbanhang.demo.controller;

import duanbanhang.demo.model.DanhMuc;
import duanbanhang.demo.repository.DanhMucRepo;
import duanbanhang.demo.service.DanhMucService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/danh-muc")
public class DanhMucController {

    @Autowired
    DanhMucService danhMucService;

    DanhMuc danhMuc = new DanhMuc(null,"","","Active",null,null);
    @GetMapping("/hien-thi")
    public String hienThi(Model m ){
        danhMucService.getData();
        m.addAttribute("listDanhMuc",danhMucService.listDanhMuc);
        m.addAttribute("danhMuc",danhMuc);
        return "danhMuc";
    }

    @PostMapping("/add-danhMuc")
    public String addDm(@Valid @ModelAttribute DanhMuc d, BindingResult b,Model model) {
        if (b.hasErrors()){
            model.addAttribute("listDanhMuc",danhMucService.listDanhMuc);
            model.addAttribute("danhMuc",d);
            return "danhMuc";
        }
        danhMucService.addDanhMuc(d);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/detail-danhMuc/{id}")
    public String sizeDetail(@PathVariable Long id, Model model) {
        model.addAttribute("danhMuc", danhMucService.danhMucDetail(id));
        return "danhMucDetail";
    }

    @PostMapping("/update-danhMuc/{id}")
    public String updateSize(@PathVariable Long id,@Valid @ModelAttribute DanhMuc s,BindingResult b) {
        if (b.hasErrors()){
            return "danhMucDetail";
        }
        danhMucService.updateDanhMuc(id,s);
        return "redirect:/danh-muc/hien-thi";
    }


}
