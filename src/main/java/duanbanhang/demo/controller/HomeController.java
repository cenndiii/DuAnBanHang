package duanbanhang.demo.controller;

import duanbanhang.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService homeService;


    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        homeService.getData();
        model.addAttribute("dayRevenue",homeService.dayRevenue);
        model.addAttribute("monthlyRevenue",homeService.monthlyRevenue);
        model.addAttribute("revenueByYear",homeService.revenueByYear);
        return "index";
    }
}
