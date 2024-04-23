package com.cts.product.service;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(int id);
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product> product);
    Product getProductByName (String name);


}