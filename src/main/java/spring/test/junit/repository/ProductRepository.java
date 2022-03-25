package spring.test.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.test.junit.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
