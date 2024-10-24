package duanbanhang.demo.service;

import duanbanhang.demo.model.MauSac;
import duanbanhang.demo.model.Size;
import duanbanhang.demo.repository.MauRepo;
import duanbanhang.demo.repository.SizeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThuocTinhService {
    @Autowired
    SizeRepo sizeRepo;

    @Autowired
    MauRepo mauRepo;

    public List<MauSac> listMauSac = new ArrayList<>();
    public List<Size> listSize = new ArrayList<>();


    public void getData(){
        listMauSac = mauRepo.findAll();
        listSize = sizeRepo.findAll();
    }


    public void addSize(Size s) {
        s.setNgayTao(LocalDateTime.now());
        sizeRepo.save(s);
    }

    public Size sizeDetail(Long id) {
        return sizeRepo.findById(id).get();
    }

    public void updateSize(Long id, Size s) {
        s.setNgaySua(LocalDateTime.now());
        s.setId(id);
        sizeRepo.save(s);
    }

    // them sua chi tiet mau !
    public void addMau(MauSac ms) {
        ms.setNgayTao(LocalDateTime.now());
        mauRepo.save(ms);
    }

    public MauSac mauSacDetail(Long id) {
        return mauRepo.findById(id).get();
    }


    public void updateMauSac(Long id, MauSac ms) {
        ms.setNgaySua(LocalDateTime.now());
        ms.setId(id);
        mauRepo.save(ms);
    }

}
