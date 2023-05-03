package com.infy.projectname.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.projectname.app.model.Product;
import com.infy.projectname.app.repository.ProductRepository;
import com.infy.projectname.app.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository pr;
	
	
	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		
		return pr.save(p);
		
	}


	@Override
	public Iterable<Product> getProducts() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Product update(Product p, int pId) {
		// TODO Auto-generated method stub
		
		Optional<Product> optional=pr.findById(pId);
		
		if (optional.isPresent()) {
			
			p.setProductId(pId);
			Product product=pr.save(p);
			
			return product;
		}
		else {
			System.out.println("update else");
			return null;
		}
	}

	@Override
	public void delete(int pId) {
		// TODO Auto-generated method stub
		
		Optional<Product> optional=pr.findById(pId);
		
		if (optional.isPresent()) {
			
			pr.deleteById(pId);
			
			
		}
		else {
			
		}
	}

}
