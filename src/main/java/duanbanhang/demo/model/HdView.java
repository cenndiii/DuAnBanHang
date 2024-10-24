package duanbanhang.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface HdView {
    public Long getId();
    public Long getIdKhachHang();
    public String getHoTen();
    public String getTrangThai();
    public LocalDateTime getNgayTao();
    public LocalDateTime getNgaySua();
    public BigDecimal getTongTien();
}
