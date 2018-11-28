package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DBTablesServlet")
public class DBTablesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try
	    {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","hr","hr");
	         out.println("connection established successfully...!!");     
	         
	         DatabaseMetaData dbmd=con.getMetaData();
	         String table[]={"TABLE"};  
	         ResultSet rs=dbmd.getTables(null,null,null,table);  
	         
	         out.println("<h1>Table List</h1>");
	         while(rs.next()){  
	        	 
	         out.println("<br/><a href=DBTableServlet target=self>"+rs.getString(3)+"</a>");
	        //out.println(table[1]);
	         }  
	         
	         
	         
	    }
	    catch (ClassNotFoundException | SQLException ex){
	       out.println(ex);
	    }
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
