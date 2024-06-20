package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginValidation {
	public boolean validate(String user,String pass) {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String query="select username,password from registration";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","sql@123");
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				if(user.equals(rs.getString(1)) && pass.equals(rs.getString(2))) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

}
