package com.example.t2009m1.service;

import com.example.t2009m1.entity.Product;
import com.example.t2009m1.reponsitory.ProductReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductReponsitory productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product stock) {
        return productRepository.save(stock);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


}
