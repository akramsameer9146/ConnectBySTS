package com.cjc.main.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Product;
import com.cjc.main.repository.ProductRepository;
import com.cjc.main.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository pr;
	
	
	@Override
	public void save(Product p) {
		// TODO Auto-generated method stub
		
		pr.save(p);
		
	}


	@Override
	public Iterable<Product> getProducts() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}


	@Override
	public String update(Product p, int pId) {
		// TODO Auto-generated method stub
		
		Optional<Product> optional=pr.findById(pId);
		
		if (optional.isPresent()) {
			
			p.setProductId(pId);
			pr.save(p);
			
			System.out.println("update if");
			return "Product has bees Updated";
		}
		else {
			System.out.println("update else");
			return "Product Does not exist";
		}
		
	}


	@Override
	public String delete(int pId) {
		// TODO Auto-generated method stub
		
		Optional<Product> optional=pr.findById(pId);
		
		if (optional.isPresent()) {
			
			pr.deleteById(pId);
			
			return "Product has bees Deleted";
		}
		else {
			return "Product Does not exist";
		}
	}

}
