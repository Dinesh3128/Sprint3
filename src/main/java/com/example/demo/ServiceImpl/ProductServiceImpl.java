package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.ResourceNotFoundException;
//import com.example.StudentDatabase.Exception.ResourceNotFoundException;
//import com.example.demo.entity.Student;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Service.ProductService;
import com.example.demo.entity1.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

//    public List<Product> getAllProducts() {
//        return productRepo.findAll();
//    }
    
//    public Product getProductByName(String name) {
//        return productRepo.findById(name).orElse(null);
//    }
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }
    
    public void delete(String name) {
        productRepo.deleteById(name);
    }
    public Product updatedb(String name, Product product) {
		// TODO Auto-generated method stub
		
		Product s1 = productRepo.findByName(name);
		
		if(s1!=null) {
			s1.setName(product.getName());   // old to new set
			s1.setDescription(product.getDescription());
			s1.setImage(product.getImage());
		return productRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}

    // Other methods...
}
