package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Product;

import com.cjc.main.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@PostMapping("addProduct")
	public String addProduct(@RequestBody Product p)
	{
		
		ps.save(p);
		return "Product Save";
	}
	
	@GetMapping("viewProduct")
	public Iterable<Product> getProducts()
	{
		Iterable<Product> prod=ps.getProducts();
		
	
		return prod;
	}
	
	@PutMapping("updateProduct/{pId}")
	public String updateProduct(@RequestBody Product p,@PathVariable int pId)
	{
		System.out.println("update calling");
			String str=ps.update(p,pId);
	
		return str;
	}
	
	@DeleteMapping("deleteProduct/{pId}")
	public String deleteProduct(@PathVariable int pId)
	{
		System.out.println("delete called");
		String str=ps.delete(pId);
		return str;
	}
}
