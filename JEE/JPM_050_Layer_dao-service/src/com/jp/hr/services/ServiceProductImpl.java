package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.daos.DaoProduct;
import com.jp.hr.daos.DaoProductImpl;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

/*
 * One layer refers to another layer through interfaces only.
 * Implementation of business rule should be done here in absence of BL layer.
 * This layer will also ensure only custom exceptions to come out. 
 */

public class ServiceProductImpl implements ServiceProduct {

	private DaoProduct daoPrd;
	
	//Resolving Dependency.
	public ServiceProductImpl(){
		daoPrd = new DaoProductImpl();
	}
	
	@Override
	public ArrayList<Product> getProductList() throws HrException {
		// TODO Auto-generated method stub
		return daoPrd.getProductList();
	}

}
