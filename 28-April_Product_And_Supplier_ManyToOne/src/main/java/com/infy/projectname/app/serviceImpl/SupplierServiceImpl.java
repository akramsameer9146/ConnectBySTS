package com.infy.projectname.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.projectname.app.model.Supplier;
import com.infy.projectname.app.repository.SupplierRepository;
import com.infy.projectname.app.service.SupplierService;



@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository sr;
	@Override
	public Supplier save(Supplier s) {
		// TODO Auto-generated method stub
		
		return sr.save(s);
	}
	@Override
	public String update(Supplier s, int sId) {
		// TODO Auto-generated method stub
		
		Optional<Supplier> optional =sr.findById(sId);
		
		if (optional.isPresent()) {
			
			s.setSupplierId(sId);
			sr.save(s);
			
			return "Supplier Updated";
			
		}
		else
		{
			return "Supplier Not Present";
		}
	}
	@Override
	public Iterable<Supplier> getSupplier() {
		// TODO Auto-generated method stub
		
		Iterable<Supplier> suppliers=sr.findAll();
		
		return suppliers;
	}

}
