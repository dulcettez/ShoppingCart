package repository;
import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public class ProductRepository {

	public interface ProductRepository extends JpaRepository<Product, Long> {
	    List<Product> findByNameContainingIgnoreCase(String keyword);
	}

}
