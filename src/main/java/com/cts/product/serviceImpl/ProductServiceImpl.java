package com.cts.product.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.entity.Product;
import com.cts.product.repository.ProductRepository;
import com.cts.product.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productrepository;
    @Override
    public List<Product> getProducts() {
        try {
            return productrepository.findAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Product getProductById(int id) {
        try {
            Product product = productrepository.findById(id).get();
            if(product == null) {
                throw new Exception("Product not found");
            }
            return product;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Product saveProduct(Product product) {
        try {
            Product save= productrepository.save(product);
            return save;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Product> saveProducts(List<Product> product) {
        try {
            return productrepository.saveAll(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        try {
            Product find = productrepository.findByName(name);
            if(find == null) {
                throw new Exception("Name not found");
            }
            return find;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}