package com.cjc.main.service;

import com.cjc.main.model.Supplier;

public interface SupplierService {

	void save(Supplier s);

	String update(Supplier s, int sId);

	Iterable<Supplier> getSupplier();

}
