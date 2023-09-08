package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.ProductService;
import com.example.demo.entity1.Product;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/post")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product); // Use createProduct instead of addProduct
    }

    @PutMapping("/update")
    public Product update(@RequestHeader String name, @RequestBody Product product) {
        return productService.updatedb(name, product);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestHeader String name) {
        productService.delete(name); 
        return "Data deleted";
    }
}
