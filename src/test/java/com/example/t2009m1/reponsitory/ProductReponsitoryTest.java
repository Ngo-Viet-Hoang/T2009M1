package com.example.t2009m1.reponsitory;

import com.example.t2009m1.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductReponsitoryTest {
    @Autowired
    ProductReponsitory productReponsitory;
    @Test
    public void testPaging() {
       int page = 3;
       int limit = 10;
        Page<Product> pageProduct = productReponsitory.findAll(
                PageRequest.of(
                        page - 1,
                        limit,
                        Sort.by(Sort.Direction.DESC, "name")));
        System.out.println("Total element" + pageProduct.getTotalElements());
        System.out.println("Total page" + pageProduct.getTotalPages());
        System.out.println("Current page" + pageProduct.getNumber());
        System.out.println("Current limit" + pageProduct.getSize());
        List<Product> list = pageProduct.getContent();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());

        }
    }
    @Test
    public void findAllByName() {
        List<Product> list = productReponsitory.search("%Chief%");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());

        }
    }

}