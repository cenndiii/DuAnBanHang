package duanbanhang.demo.repository;

import duanbanhang.demo.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MauRepo extends JpaRepository<MauSac,Long> {
    List<MauSac> findByTrangThai(String status);
}
