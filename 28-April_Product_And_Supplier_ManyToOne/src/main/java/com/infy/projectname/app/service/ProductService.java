package com.infy.projectname.app.service;

import com.infy.projectname.app.model.Product;

public interface ProductService {

	Product save(Product p);

	Iterable<Product> getProducts();

	Product update(Product p, int pId);

	 void delete(int pId);

}
