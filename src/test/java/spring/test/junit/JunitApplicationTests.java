package spring.test.junit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.test.junit.entity.Product;
import spring.test.junit.repository.ProductRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class JunitApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testCreate() {
        Product p = new Product();
        p.setId(1L);
        p.setName("iPhone XR");
        p.setDesc("Fantastic");
        p.setPrice(1000.00);
        productRepository.save(p);
        assertNotNull(productRepository.findById(1L).get());
    }
    @Test
    public void testReadAll(){
        List<Product> list = productRepository.findAll();
        assertThat(list).size().isGreaterThan(0);
    }
    @Test
    public void testRead() {
        Product product = productRepository.findById(1L).get();
        assertEquals("iPhone XR", product.getName());
    }
    @Test
    public void testUpdate() {
        Product p = productRepository.findById(1L).get();
        p.setPrice(800.00);
        productRepository.save(p);
        assertNotEquals(800.00,productRepository.findById(1L).get().getPrice());
    }
    @Test
    public void testDelete() {
        productRepository.deleteById(1L);
        assertThat(productRepository.existsById(1L)).isFalse();
    }



}
