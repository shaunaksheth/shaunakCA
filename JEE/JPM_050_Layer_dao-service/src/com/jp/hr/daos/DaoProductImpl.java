package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jp.hr.entities.Product;
import com.jp.hr.exceptions.HrException;

/*
 * The ClassNotFoundException , SQLException must not out of DAO 
 * 
 */

public class DaoProductImpl implements DaoProduct {

	public Connection getConnection() throws ClassNotFoundException, SQLException{
			String driverName = "oracle.jdbc.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521/orcl";
			String userName = "hr";
			String password = "hr";
			
			
	Class.forName( driverName);
	return DriverManager.getConnection(url,userName,password);
	}

	public void closeConnection(Connection connect) throws SQLException{
		connect.close();
	}
	
	@Override
	public ArrayList<Product> getProductList() throws HrException{
		ArrayList<Product> prdList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = getConnection();
			
			stmt = connect.createStatement();
			rs = stmt.executeQuery("Select * from product");
			
			while(rs.next()){
				int productId=rs.getInt("product_id");
				String productCategory = rs.getString("Product_Category");
				double productPrice = rs.getDouble("Product_Price");
				String productName = rs.getString("Product_Name");
				prdList.add(new Product(productId, productCategory, productName,productPrice));
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new HrException("Problem in fetching.",e);			
		} finally{
			try {
				rs.close();
				stmt.close();
				closeConnection(connect);
			} catch (SQLException e) {
				throw new HrException("Problem in Cloising Resources.",e);
			}
		}
				
		return prdList;
		
	}
}
