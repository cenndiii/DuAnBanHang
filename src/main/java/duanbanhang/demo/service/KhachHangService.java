package duanbanhang.demo.service;

import duanbanhang.demo.model.KhachHang;
import duanbanhang.demo.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    KhachHangRepo khachHangRepo;

    public List<KhachHang> listKh = new ArrayList<>();

    public void getData(){
        listKh = khachHangRepo.findAll();
    }

    public void addKhachHang(KhachHang dm) {
        dm.setNgayTao(LocalDateTime.now());
        khachHangRepo.save(dm);
    }

    public KhachHang khahcHangDetail(Long id) {
        return khachHangRepo.findById(id).get();
    }

    public void updateKhachHang(Long id, KhachHang dm) {
        dm.setNgaySua(LocalDateTime.now());
        dm.setId(id);
        khachHangRepo.save(dm);
    }
}
