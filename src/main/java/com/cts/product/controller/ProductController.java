package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.entity.Product;

import com.cts.product.service.ProductService;
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> kk=	productService.getProducts();
        return new ResponseEntity<>(kk,HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        Product ck=	productService.getProductById(id);
        return ResponseEntity.ok(ck);
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity<Product> getProductById(@PathVariable String name){
        Product ck=	productService.getProductByName(name);
        return ResponseEntity.ok(ck);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product product1 = productService.saveProduct(product);
        return ResponseEntity.ok(product1);
    }
    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> product){
        List<Product> dk = productService.saveProducts(product);
        return new ResponseEntity<>(dk,HttpStatus.CREATED);
    }
}
