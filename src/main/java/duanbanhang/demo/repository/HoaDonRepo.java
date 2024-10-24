package duanbanhang.demo.repository;


import duanbanhang.demo.model.HdView;
import duanbanhang.demo.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface HoaDonRepo extends JpaRepository<HoaDon, Long> {
    List<HoaDon> findAllByTrangThai(String trangThai);

    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id desc",nativeQuery = true)
    List<HdView> listAllHd();

    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "where hd.ngay_tao between :startDate and :endDate\n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id asc",nativeQuery = true)
    List<HdView> findAllByNgayTaoBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate")LocalDateTime endDate);

    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "where hd.ngay_tao >= :startDate \n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id asc",nativeQuery = true)
    List<HdView> findAllByNgayTaoAfter(@Param("startDate") LocalDateTime startDate);

    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "where hd.ngay_tao <= :endDate \n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id asc",nativeQuery = true)
    List<HdView> findAllByNgayTaoBefore(@Param("endDate") LocalDateTime endDate);


    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "where hd.id = :id \n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id asc",nativeQuery = true)
    List<HdView> findAllById(@Param("id") Long id);


    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "where hd.id_khach_hang = :id \n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id asc",nativeQuery = true)
    List<HdView> findAllByKhachHang_Id(@Param("id") Long id);

    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "where kh.ho_ten like %:hoTen% \n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id asc",nativeQuery = true)
    List<HdView> findAllByKhachHang_HoTenContains(@Param("hoTen") String hoTen);

    @Query(value = "SELECT hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua,  hd.trang_thai, sum(hdct.tong_tien) as 'tong_tien'\n" +
            "FROM hoa_don hd\n" +
            "FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "where hd.trang_thai like %:trangThai% \n" +
            "group by hd.id, hd.id_khach_hang, kh.ho_ten, hd.ngay_tao, hd.ngay_sua, hd.trang_thai\n" +
            "order by hd.id asc",nativeQuery = true)
    List<HdView> findAllByTrangThaiContains(@Param("trangThai") String trangThai);

    @Query(value = "SELECT sum(hdct.tong_tien) as 'tong_tien'\n" +
            "            FROM hoa_don hd\n" +
            "            FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "            left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "            where hd.ngay_tao between DATEADD(day ,-1,getdate()) and CAST(GETDATE() as datetime)",nativeQuery = true)
    BigDecimal findTotalDay();

    @Query(value = "SELECT sum(hdct.tong_tien) as 'tong_tien'\n" +
            "            FROM hoa_don hd\n" +
            "            FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "            left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "            where hd.ngay_tao between DATEADD(month ,-1,getdate()) and CAST(GETDATE() as datetime)",nativeQuery = true)
    BigDecimal findTotalMonth();

    @Query(value = "SELECT sum(hdct.tong_tien) as 'tong_tien'\n" +
            "            FROM hoa_don hd\n" +
            "            FULL JOIN hdct ON hd.id = hdct.id_hoa_don\n" +
            "            left JOIN khach_hang kh ON hd.id_khach_hang = kh.id\n" +
            "            where hd.ngay_tao between DATEADD(YEAR ,-1,getdate()) and CAST(GETDATE() as datetime)",nativeQuery = true)
    BigDecimal findTotalYear();
}
