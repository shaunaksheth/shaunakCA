package com.jp.hr.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jp.hr.entities.Employee;
import com.jp.hr.exceptions.HrException;

/*
 * The ClassNotFoundException , SQLException must not come out of DAO class.
 * The database specific entities must not come out of the class(like Exception).
 * Each and every resource (connection, statement, ResultSet) MUST BE CLOSED before coming out. 
 * Always prefer statement over PreparedStatement for non interactive queries.
 * Fetch the data page wise. 20 records per page.
 * Prefer mentioning column names instead of column position in getXXX methods
 *  
 */

public class DaoEmployeeImpl implements DaoEmployee {

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
	public ArrayList<Employee> getEmpList() throws HrException{
		ArrayList<Employee> empList = new ArrayList<>();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect = getConnection();
			stmt = connect.createStatement();
			rs = stmt.executeQuery("Select * from Employees");
			
			while(rs.next()){
				int empId=rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				empList.add(new Employee(empId, firstName, lastName));
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
				
		return empList;
		
	}
}
