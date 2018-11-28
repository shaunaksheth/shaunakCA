package com.jp.hr.daos;

import java.util.ArrayList;

import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

public interface DaoProduct {
	public ArrayList<Product> getProductList() throws HrException;

}
