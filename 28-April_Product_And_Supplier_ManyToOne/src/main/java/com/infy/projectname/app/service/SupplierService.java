package com.infy.projectname.app.service;

import com.infy.projectname.app.model.Supplier;

public interface SupplierService {

	Supplier save(Supplier s);

	String update(Supplier s, int sId);

	Iterable<Supplier> getSupplier();

}
