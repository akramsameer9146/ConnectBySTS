package com.cjc.main.service;

import com.cjc.main.model.Product;

public interface ProductService {

	void save(Product p);

	Iterable<Product> getProducts();

	String update(Product p, int pId);

	String delete(int pId);

}
