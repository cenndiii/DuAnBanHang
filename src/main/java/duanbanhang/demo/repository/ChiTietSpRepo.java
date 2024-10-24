package duanbanhang.demo.repository;


import duanbanhang.demo.model.Ctsp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChiTietSpRepo extends JpaRepository<Ctsp,Long> {
    List<Ctsp> findByTrangThai(String status);
}
