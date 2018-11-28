package com.jp.config.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Lazy Instantiation: Deferring the object creation until receipt of the first request. 
 */


//@WebServlet("/process3")
public class Process3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Process3(){
		System.out.println("Object Created");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("In Proicess 3");
	
	ServletContext ctx = super.getServletContext();
	System.out.println(ctx.getInitParameter("CompanyName"));
	
	ServletConfig cfg = super.getServletConfig();
	System.out.println(cfg.getInitParameter("PageHead"));
	
	}

}
