package com.example.t2009m1.api;


import com.example.t2009m1.entity.Product;
import com.example.t2009m1.reponsitory.ProductReponsitory;
import com.example.t2009m1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "api/v1/products")
public class ProductApi {
    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getList() {
        return ResponseEntity.ok(productService.findAll());
    }



    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> getDetail(@PathVariable Long id) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }


    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> optionalProduct = productService.findById(id);
        if (!optionalProduct.isPresent()) {
            ResponseEntity.badRequest().build();
        }
        Product existProduct = optionalProduct.get();
        // map object
        existProduct.setName(product.getName());
        return ResponseEntity.ok(productService.save(existProduct));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (!productService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
