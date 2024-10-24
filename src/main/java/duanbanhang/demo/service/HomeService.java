package duanbanhang.demo.service;

import duanbanhang.demo.model.HdView;
import duanbanhang.demo.repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {
    @Autowired
    HoaDonRepo hoaDonRepo;


    public BigDecimal dayRevenue = BigDecimal.ZERO;
    public BigDecimal monthlyRevenue= BigDecimal.ZERO;
    public BigDecimal revenueByYear= BigDecimal.ZERO;

    public void getData(){
        dayRevenue = hoaDonRepo.findTotalDay();
        monthlyRevenue= hoaDonRepo.findTotalMonth();
        revenueByYear= hoaDonRepo.findTotalYear();
    }
}
