package com.example.t2009m1.reponsitory;

import com.example.t2009m1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReponsitory extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContains(String name);
    @Query(value = "select p from Product p WHERE p.name LIKE :name")
    List<Product> search(@Param("name") String name);


}
