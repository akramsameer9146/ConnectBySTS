package com.infy.projectname.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.projectname.app.model.Supplier;



public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
