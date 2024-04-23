package com.cts.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    Product findByName(String name);


    //List<Product> findAll(Product);

}