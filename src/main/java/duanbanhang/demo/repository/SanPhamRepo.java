package duanbanhang.demo.repository;

import duanbanhang.demo.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SanPhamRepo extends JpaRepository<SanPham,Long> {
    List<SanPham> findByTrangThai(String s);

}
