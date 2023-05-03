package com.cjc.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Supplier;
import com.cjc.main.repository.SupplierRepository;
import com.cjc.main.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierRepository sr;
	@Override
	public void save(Supplier s) {
		// TODO Auto-generated method stub
		
		sr.save(s);
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
