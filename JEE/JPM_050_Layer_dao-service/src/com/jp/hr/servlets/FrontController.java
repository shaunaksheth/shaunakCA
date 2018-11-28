package com.jp.hr.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.hr.entities.Employee;
import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;
import com.jp.hr.services.ServiceEmployee;
import com.jp.hr.services.ServiceEmployeeImpl;
import com.jp.hr.services.ServiceProduct;
import com.jp.hr.services.ServiceProductImpl;

@WebServlet("*.do") // A generic url.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServiceEmployee services;
	private ServiceProduct prdServices;
	
	@Override
	public void init() throws ServletException {
		services = new ServiceEmployeeImpl();
		prdServices = new ServiceProductImpl();
		System.out.println(services);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = getCommnad(request.getRequestURI());
		try {
			switch(command){
			case "empList":{
				ArrayList<Employee> empList = services.getEmpList();
				System.out.println(empList);
				request.setAttribute("empList", empList);
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/EmpList.jsp");
				dispatch.forward(request, response);
			}
			case "prdList":{
				ArrayList<Product> prdList = prdServices.getProductList();
				//System.out.println(prdList);
				request.setAttribute("prdList", prdList);
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/jsps/EmpList.jsp");
				dispatch.forward(request, response);
			}
			}
		} catch (HrException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String getCommnad(String uri){
		int leftPosi=uri.lastIndexOf("/");
		int rtPosi=uri.lastIndexOf(".");
		return uri.substring(leftPosi+1, rtPosi);
	}

}
