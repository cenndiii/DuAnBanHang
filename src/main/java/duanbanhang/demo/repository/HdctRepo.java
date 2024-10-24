package duanbanhang.demo.repository;

import duanbanhang.demo.model.Hdct;
import duanbanhang.demo.model.Spct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HdctRepo extends JpaRepository<Hdct,Long> {
    List<Hdct> findByTrangThai(String s);
    @Query(value = "select hdct.id_hoa_don, sp.ten_san_pham, hdct.so_luong_mua, hdct.gia_ban, hdct.tong_tien, hdct.trang_thai, hdct.ngay_tao, hdct.ngay_sua from hdct   join ctsp on hdct.id_ctsp = ctsp.id join san_pham sp on ctsp.id_sp = sp.id where hdct.id_hoa_don = :idHoaDon",nativeQuery = true)
    List<Spct> listSpct(@Param("idHoaDon") Long id);
}
