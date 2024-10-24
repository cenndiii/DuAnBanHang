package duanbanhang.demo.repository;

import duanbanhang.demo.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SizeRepo extends JpaRepository<Size,Long> {
    List<Size> findByTrangThai(String s);
}
