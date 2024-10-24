package duanbanhang.demo.controller;

import duanbanhang.demo.model.Ctsp;
import duanbanhang.demo.repository.ChiTietSpRepo;
import duanbanhang.demo.repository.MauRepo;
import duanbanhang.demo.repository.SanPhamRepo;
import duanbanhang.demo.repository.SizeRepo;
import duanbanhang.demo.service.CtspService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/ctsp")
public class CtspController {
    @Autowired
    CtspService ctspService;

    Ctsp ctsp = new Ctsp(null,null,null,null,null,null,"Active",null,null);

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        ctspService.getData();
        model.addAttribute("listCtsp",ctspService.listCtsp);
        model.addAttribute("listSanPham",ctspService.listSp);
        model.addAttribute("listSize",ctspService.listSize);
        model.addAttribute("listMau", ctspService.listMau);
        model.addAttribute("ctsp",ctsp);
        return "ctsp";
    }

    @PostMapping("/add-ctsp")
    public String addSize(@Valid @ModelAttribute Ctsp d, BindingResult b,Model model) {
        if (b.hasErrors()){
            model.addAttribute("listCtsp",ctspService.listCtsp);
            model.addAttribute("listSanPham",ctspService.listSp);
            model.addAttribute("listSize",ctspService.listSize);
            model.addAttribute("listMau", ctspService.listMau);
            model.addAttribute("ctsp",d);
            return "ctsp";
        }
        ctspService.addCtsp(d);
        return "redirect:/ctsp/hien-thi";
    }

    @GetMapping("/detail-ctsp/{id}")
    public String sizeDetail(@PathVariable Long id, Model model) {
        ctspService.getData();
        model.addAttribute("ctsp",ctspService.ctspDetail(id));
        model.addAttribute("listSanPham",ctspService.listSp);
        model.addAttribute("listSize",ctspService.listSize);
        model.addAttribute("listMau", ctspService.listMau);
        return "ctspDetail";
    }

    @PostMapping("/update-ctsp/{id}")
    public String updateSize(@PathVariable Long id,@Valid @ModelAttribute Ctsp s,BindingResult b,Model model) {
        if (b.hasErrors()){
            model.addAttribute("listSanPham",ctspService.listSp);
            model.addAttribute("listSize",ctspService.listSize);
            model.addAttribute("listMau", ctspService.listMau);
            model.addAttribute("ctsp",s);
            return "ctspDetail";
        }
        ctspService.updateCtsp(id,s);
        return "redirect:/ctsp/hien-thi";
    }
}
