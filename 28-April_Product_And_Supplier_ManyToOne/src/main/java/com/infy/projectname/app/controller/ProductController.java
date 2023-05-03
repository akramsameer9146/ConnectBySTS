package com.infy.projectname.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.projectname.app.model.Product;
import com.infy.projectname.app.response.BaseResponse;
import com.infy.projectname.app.service.ProductService;



@CrossOrigin("*")
@RestController
public class ProductController {
	
	@Autowired
	ProductService ps;
	
	@PostMapping("addProduct")
	public ResponseEntity<BaseResponse<Product>> addProduct(@RequestBody Product p)
	{	
		Product prod=ps.save(p);
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(201, "A New Product Is Created", prod);
		
		ResponseEntity<BaseResponse<Product>> responseEntity=new ResponseEntity<BaseResponse<Product>>(baseResponse, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("viewProduct")
	public ResponseEntity<BaseResponse<Product>> getProducts()
	{
		Iterable<Product> prod=ps.getProducts();
		
		BaseResponse<Iterable<Product>> baseResponse=new BaseResponse<Iterable<Product>>(200, "All Products Data Are Fetched", prod);
		
//		ResponseEntity<BaseResponse<Iterable<Product>>> responseEntity=new ResponseEntity<BaseResponse<Iterable<Product>>>(baseResponse,HttpStatus.OK);
		
		ResponseEntity<BaseResponse<Product>> responseEntity=new ResponseEntity(baseResponse,HttpStatus.OK);

		return responseEntity;
	}
	
	@PutMapping("updateProduct/{pId}")
	public ResponseEntity<BaseResponse<Product>> updateProduct(@RequestBody Product p,@PathVariable int pId)
	{
		
		Product product=ps.update(p,pId);
		
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(200, "Product Is Updated", product);
		
		ResponseEntity<BaseResponse<Product>> responseEntity=new ResponseEntity(baseResponse, HttpStatus.OK);
	
		return responseEntity;
	}
	
	@DeleteMapping("deleteProduct/{pId}")
	public ResponseEntity<BaseResponse<Product>> deleteProduct(@PathVariable int pId)
	{
		
		ps.delete(pId);
		
		BaseResponse<Product> baseResponse=new BaseResponse<Product>(200, "Product Is Deleted", null);
		
		ResponseEntity<BaseResponse<Product>> responseEntity=new ResponseEntity<BaseResponse<Product>>(baseResponse, HttpStatus.OK);
		
		return responseEntity;
	}
}
