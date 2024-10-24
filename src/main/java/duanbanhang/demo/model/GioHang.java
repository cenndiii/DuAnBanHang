package duanbanhang.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GioHang {
    public Long id;
    public String tenSanPham;
    public String tenMau;
    public String tenSize;
    public BigDecimal giaBan;
    public Integer soLuong;

}
