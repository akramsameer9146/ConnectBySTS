package com.cjc.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Supplier;
import com.cjc.main.service.SupplierService;

@CrossOrigin("*")
@RestController
public class SupplierController {
	
	
	@Autowired
	SupplierService supser;
	
	@PostMapping("addSupplier")
	public String addSupplier(@RequestBody Supplier s)
	{
		supser.save(s);
				
		return "SupplierSave";
	}
	
	@GetMapping("getSupplier")
	public Iterable<Supplier> getSupplier()
	{
		Iterable<Supplier> suppliers=supser.getSupplier();
		
		return suppliers;
	}
	
//	@PutMapping("updateSupplier/{sId}")
//	public String updateSupplier(@RequestBody Supplier s,@PathVariable int sId)
//	{
//			String str=supser.update(s,sId);
//	
//		return str;
//	}
}
