package com.jp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The response 
 * if altered by this Servlet does not reach to next in chain because the forward dispatching wipes off the old response.
 * In the forward chain, the last entity to generate full & final response.
 * 
 * The request if altered, is sent to the next in chain as altered.
 * 
 * Query String: User entries passed through address bar when method type is GET.
 * 		Separated by '?' from URI.\
 * 		Separated by '&' from another field.
 * 		prefer GEt if data is small in size and not Sensitive.
 * 
 * Form Data: user entries passed through separate connection when method the is POST
 *  	Form Data is not exposed on address bar.
 *  
 *  	Always send sensitive data or data of large size as form data.
 *  
 *  Request.getParamaeter(): Brings every data in string form.
 *  	One method to bring Query String or form data
 */
@WebServlet("/process1")
public class Process1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param1 = request.getParameter("param1");	
		//PrintWriter out = response.getWriter();
		System.out.println("In Servlet Process1"+ param1);
		
			RequestDispatcher dispatch = request.getRequestDispatcher("/process2");
			dispatch.forward(request, response);
			System.out.println("In Servlet Process1");
			
	}

}
