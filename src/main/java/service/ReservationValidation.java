package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ReservationValidation {
	
	public void validate(int trainNo,String classType,String journey,String from,String to) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		int min=10000;
    	int max=99999;
    	
		Random random = new Random();
        int pnrNumber = random.nextInt(max) + min;
        
		String query="insert into reservation values (?, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis", "root", "sql@123");
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, pnrNumber);
			pstmt.setInt(2, trainNo);
			pstmt.setString(3, classType);
			pstmt.setString(4, journey);
			pstmt.setString(5, from);
			pstmt.setString(6, to);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
