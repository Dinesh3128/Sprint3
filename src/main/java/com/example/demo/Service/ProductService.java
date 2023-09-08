package com.example.demo.Service;

import com.example.demo.entity1.Product;

	public interface ProductService {


//	    Product getProductByName(String name);

	    Product addProduct(Product product);

		Product updatedb(String name,Product product );

	    void delete(String name);



	    // Other methods specific to product management...
	}

