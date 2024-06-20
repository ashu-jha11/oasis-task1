package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationValidation {
	public void validate(String user,String email,String gender,int age,int phno,String pass) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String query="insert into registration values(?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","sql@123");
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, user);
			pstmt.setString(2, email);
			pstmt.setString(3, gender);
			pstmt.setInt(4, age);
			pstmt.setInt(5, phno);
			pstmt.setString(6, pass);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
