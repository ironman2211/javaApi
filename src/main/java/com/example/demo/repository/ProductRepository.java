package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE "+
           "p.name LIKE CONCAT('%',:query,'%')"+
           "Or p.description LIKE CONCAT('%',:query,'%')")
    List<Product> searchProducts(String query);

//    @Query(value = "SELECT * FROM products p WHERE "+
//            "p.name LIKE CONCAT('%',:query,'%')"+
//            "Or p.description LIKE CONCAT('%',:query,'%')"+"Or p.sku LIKE CONCAT('%',:query,'%')",nativeQuery = true)
//    List<Product> searchProducts(String query);
}
