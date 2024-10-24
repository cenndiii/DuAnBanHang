package duanbanhang.demo.repository;

import duanbanhang.demo.model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DanhMucRepo extends JpaRepository<DanhMuc,Long> {
    List<DanhMuc> findByTrangThai(String trangThai);
}
