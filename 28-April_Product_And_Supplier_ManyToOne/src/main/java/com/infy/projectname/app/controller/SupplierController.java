package com.infy.projectname.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.projectname.app.model.Supplier;
import com.infy.projectname.app.response.BaseResponse;
import com.infy.projectname.app.service.SupplierService;



@CrossOrigin("*")
@RestController
public class SupplierController {
	
	
	@Autowired
	SupplierService supser;
	
	@PostMapping("addSupplier")
	public ResponseEntity<BaseResponse<Supplier>> addSupplier(@RequestBody Supplier s)
	{
		Supplier supplier=supser.save(s);
		
		BaseResponse<Supplier> baseResponse=new BaseResponse<Supplier>(201, "A New Supplier Is Created", supplier);
			
		ResponseEntity<BaseResponse<Supplier>> responseEntity=new ResponseEntity(baseResponse, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("getSupplier")
	public ResponseEntity<BaseResponse<Supplier>> getSupplier()
	{
		Iterable<Supplier> suppliers=supser.getSupplier();
		
		BaseResponse<Iterable<Supplier>> baseResponse=new BaseResponse(200, "All Suppliers Data Are Fetched", suppliers);
		
		ResponseEntity<BaseResponse<Supplier>> responseEntity=new ResponseEntity(baseResponse, HttpStatus.OK);
		
		return responseEntity;
	}
	
//	@PutMapping("updateSupplier/{sId}")
//	public String updateSupplier(@RequestBody Supplier s,@PathVariable int sId)
//	{
//			String str=supser.update(s,sId);
//	
//		return str;
//	}
}
