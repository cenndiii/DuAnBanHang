package duanbanhang.demo.repository;

import duanbanhang.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhachHangRepo extends JpaRepository<KhachHang,Long> {
    List<KhachHang> findByTrangThai(String status);
}
