package duanbanhang.demo.service;

import duanbanhang.demo.model.DanhMuc;
import duanbanhang.demo.model.SanPham;
import duanbanhang.demo.repository.DanhMucRepo;
import duanbanhang.demo.repository.SanPhamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    @Autowired
    DanhMucRepo danhMucRepo;

    public List<DanhMuc> listDanhMuc = new ArrayList<>();
    public List<SanPham> listSanPham = new ArrayList<>();

    public void getData(){
        listDanhMuc = danhMucRepo.findByTrangThai("Active");
        listSanPham = sanPhamRepo.findAll();
    }

    public void addSanPham(SanPham sp) {
        sp.setNgayTao(LocalDateTime.now());
        sanPhamRepo.save(sp);
    }

    public SanPham sanPhamDetail(Long id) {
        return sanPhamRepo.findById(id).get();
    }

    public void updateSanPham(Long id, SanPham sp) {
        sp.setNgaySua(LocalDateTime.now());
        sp.setId(id);
        sanPhamRepo.save(sp);
    }
}
