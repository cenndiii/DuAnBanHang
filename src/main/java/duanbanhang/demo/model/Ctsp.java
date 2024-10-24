package duanbanhang.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ctsp")
@EntityListeners(AuditingEntityListener.class)
public class Ctsp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size size;

    @Digits(integer = 18,fraction = 2,message = "Yeu cau nhap chu so !")
    @NotNull(message = "Gia khong duoc de trong")
    @DecimalMin(value = "1",message = "Gia lon hon 0")
    private BigDecimal giaBan;

    @NotNull(message = "So luong khong duoc de trong")
    @Min(value = 1,message = "Yeu cau nhap so lon hon 1 !")
    private Integer soLuongTon;

    @NotEmpty
    private String trangThai;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime ngayTao;
    private LocalDateTime ngaySua;
}
