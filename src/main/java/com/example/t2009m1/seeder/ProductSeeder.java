package com.example.t2009m1.seeder;

import com.example.t2009m1.entity.Product;
import com.example.t2009m1.reponsitory.ProductReponsitory;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class ProductSeeder implements CommandLineRunner {
    @Autowired
    ProductReponsitory productReponsitory;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        int maxPrice = 20000;
        int minPrice = 1000;
        Random random = new Random();
        int numberOfProduct = 1000;
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < numberOfProduct; i++) {
            products.add(Product.builder()
                    .name(faker.name().title())
                    .price(random.nextInt(maxPrice - minPrice) + minPrice)
                    .status(1)
                    .build());

        }
        productReponsitory.saveAll(products);

    }
}
