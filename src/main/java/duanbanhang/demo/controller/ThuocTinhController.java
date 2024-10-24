package duanbanhang.demo.controller;

import duanbanhang.demo.model.MauSac;
import duanbanhang.demo.model.Size;
import duanbanhang.demo.repository.MauRepo;
import duanbanhang.demo.repository.SizeRepo;
import duanbanhang.demo.service.ThuocTinhService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/thuoc-tinh")
public class ThuocTinhController {


    @Autowired
    ThuocTinhService thuocTinhService;

    Size size = new Size(null,"","","Active",null,null);
    MauSac mauSac = new MauSac(null,"","","Active",null,null);

    @GetMapping("/hien-thi")
    public String thuocTinh(Model m) {
        thuocTinhService.getData();
        m.addAttribute("listSize", thuocTinhService.listSize);
        m.addAttribute("listMau", thuocTinhService.listMauSac);
        m.addAttribute("size", size);
        m.addAttribute("mauSac", mauSac);
        return "thuocTinh";
    }

    // them sua chi tiet size !
    @PostMapping("/add-size")
    public String addSize(@Valid @ModelAttribute Size s,BindingResult b, Model model) {
        if (b.hasErrors()) {
            model.addAttribute("listSize", thuocTinhService.listSize);
            model.addAttribute("listMau", thuocTinhService.listMauSac);
            model.addAttribute("size", s);
            model.addAttribute("mauSac",mauSac);
            return "thuocTinh";
        }
        thuocTinhService.addSize(s);
        return "redirect:/thuoc-tinh/hien-thi";
    }


    @GetMapping("/detail-size/{id}")
    public String sizeDetail(@PathVariable Long id, Model model) {
        model.addAttribute("size",thuocTinhService.sizeDetail(id));
        return "sizeDetail";
    }

    @PostMapping("/update-size/{id}")
    public String updateSize(@PathVariable Long id,@Valid @ModelAttribute Size s,BindingResult b) {
        if (b.hasErrors()) {
            return "sizeDetail";
        }
        thuocTinhService.updateSize(id,s);
        return "redirect:/thuoc-tinh/hien-thi";
    }


    // them sua chi tiet mau !
    @PostMapping("/add-mauSac")
    public String addMau(@Valid @ModelAttribute MauSac ms, BindingResult b, Model model) {
        if (b.hasErrors()) {
            model.addAttribute("listSize", thuocTinhService.listSize);
            model.addAttribute("listMau", thuocTinhService.listMauSac);
            model.addAttribute("size", size);
            model.addAttribute("mauSac", ms);
            return "thuocTinh";
        }
        thuocTinhService.addMau(ms);
        return "redirect:/thuoc-tinh/hien-thi";
    }


    @GetMapping("/detail-mauSac/{id}")
    public String mauSacDetail(@PathVariable Long id, Model model) {
        model.addAttribute("mauSac",thuocTinhService.mauSacDetail(id));
        return "mauDetail";
    }

    @PostMapping("/update-mauSac/{id}")
    public String updateMauSac(@PathVariable Long id,@Valid @ModelAttribute MauSac s,BindingResult b) {
        if (b.hasErrors()) {
            return "mauDetail";
        }
        thuocTinhService.updateMauSac(id,s);
        return "redirect:/thuoc-tinh/hien-thi";
    }


}
