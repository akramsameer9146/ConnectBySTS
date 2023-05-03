package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjc.main.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
