package com.infy.projectname.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.projectname.app.model.Product;



public interface ProductRepository  extends JpaRepository<Product, Integer> {

}
