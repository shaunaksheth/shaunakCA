package com.jp.hr.daos;

import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

public interface DaoEmployee {
	public ArrayList<Employee> getEmpList() throws HrException;
}
