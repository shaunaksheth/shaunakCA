package com.jp.hr.services;

import java.util.ArrayList;

import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

public interface ServiceProduct {
	ArrayList<Product> getProductList() throws HrException;
}
