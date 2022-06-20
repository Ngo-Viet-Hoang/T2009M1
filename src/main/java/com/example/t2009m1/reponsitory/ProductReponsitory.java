package com.example.t2009m1.reponsitory;

import com.example.t2009m1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReponsitory extends JpaRepository<Product, Long> {



}
