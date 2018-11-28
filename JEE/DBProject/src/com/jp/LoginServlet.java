package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username =request.getParameter("txtName");
		String password = request.getParameter("txtPassword");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try
		{
		         Class.forName("oracle.jdbc.driver.OracleDriver");
		         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","hr","hr");
		         PreparedStatement pstmt = con.prepareStatement("Select count(*) from employees where first_name=? and last_name=?");
		         pstmt.setString(1, username);
		         pstmt.setString(2, password);
		         out.println("connection established successfully...!!");     
		         ResultSet rs=pstmt.executeQuery();
		         out.println("Query Executed successfully...!!");
		         rs.next();
		         int count = rs.getInt(1);
		         if (count>0)
		         {
		        	 out.println(count);
		        	 con.close();
		        	 response.sendRedirect("DBTablesServlet");
		         }
		        else{
						out.println("<h1>Invalid User</h1>");
					}
		    }
		    catch (ClassNotFoundException | SQLException ex){
		       out.println(ex);
		    }
			
				
		out.flush();
	}

}
