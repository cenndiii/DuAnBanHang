package duanbanhang.demo.service;

import duanbanhang.demo.model.Ctsp;
import duanbanhang.demo.model.MauSac;
import duanbanhang.demo.model.SanPham;
import duanbanhang.demo.model.Size;
import duanbanhang.demo.repository.ChiTietSpRepo;
import duanbanhang.demo.repository.MauRepo;
import duanbanhang.demo.repository.SanPhamRepo;
import duanbanhang.demo.repository.SizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CtspService {

    public List<Ctsp> listCtsp = new ArrayList<>();
    public List<SanPham> listSp = new ArrayList<>();
    public List<MauSac> listMau = new ArrayList<>();
    public List<Size> listSize = new ArrayList<>();

    @Autowired
    ChiTietSpRepo chiTietSpRepo;
    @Autowired
    SanPhamRepo sanPhamRepo;
    @Autowired
    MauRepo mauRepo;
    @Autowired
    SizeRepo sizeRepo;

    public void getData(){
        listCtsp = chiTietSpRepo.findAll();
        listSp =sanPhamRepo.findByTrangThai("Active");
        listMau = mauRepo.findByTrangThai("Active");
        listSize = sizeRepo.findByTrangThai("Active");
    }

    public void addCtsp(Ctsp sp) {
        sp.setNgayTao(LocalDateTime.now());
        chiTietSpRepo.save(sp);
    }

    public Ctsp ctspDetail(Long id) {
        return chiTietSpRepo.findById(id).get();
    }

    public void updateCtsp(Long id, Ctsp sp) {
        sp.setNgaySua(LocalDateTime.now());
        sp.setId(id);
        chiTietSpRepo.save(sp);
    }
}
