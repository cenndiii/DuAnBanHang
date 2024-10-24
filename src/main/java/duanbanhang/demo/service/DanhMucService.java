package duanbanhang.demo.service;

import duanbanhang.demo.model.DanhMuc;
import duanbanhang.demo.repository.DanhMucRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DanhMucService {
    @Autowired
    DanhMucRepo danhMucRepo;

    public List<DanhMuc> listDanhMuc = new ArrayList<>();

    public void getData(){
        listDanhMuc = danhMucRepo.findAll();
    }

    public void addDanhMuc(DanhMuc dm) {
        dm.setNgayTao(LocalDateTime.now());
        danhMucRepo.save(dm);
    }

    public DanhMuc danhMucDetail(Long id) {
        return danhMucRepo.findById(id).get();
    }

    public void updateDanhMuc(Long id, DanhMuc dm) {
        dm.setNgaySua(LocalDateTime.now());
        dm.setId(id);
        danhMucRepo.save(dm);
    }
}
