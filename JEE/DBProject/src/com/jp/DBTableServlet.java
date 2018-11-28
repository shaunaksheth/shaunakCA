package com.jp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DBTableServlet")
public class DBTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		String tablename = request.getParameter("tablename");
		System.out.println(tablename);
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","hr","hr");
			st=con.createStatement();
			ResultSet rs=st.executeQuery("Select * from "+tablename);
			ResultSetMetaData resd= rs.getMetaData();
			int colcount=resd.getColumnCount();
			PrintWriter out=response.getWriter();
			out.write("<table border=2pt>");
			out.write("<tr>");
        while (colcount>0)
        {
			
			out.write("<td>");
        	out.write("<br/>"+resd.getColumnName(colcount));
        	colcount--;
            out.write("</td>");  	
        	    		
        }
        
        while (rs.next())
        {
			out.write("<tr>");
			colcount=resd.getColumnCount();
			  while (colcount>0)
		        {
					
					out.write("<td>");
		        	out.write(rs.getString(colcount));
		        	colcount--;
		        	out.write("</td>");  	
		       } 
				out.write("</tr>");
          }
        	
        out.write("</table>");

	}
	catch (ClassNotFoundException|SQLException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();}
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
