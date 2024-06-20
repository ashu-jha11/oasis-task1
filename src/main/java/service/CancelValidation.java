package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancelValidation {
	
	public int validate(int pnrNo) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int count=0;
		
		String query="delete from reservation where pnrNo=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis", "root", "sql@123");
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, pnrNo);
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return count;
	}

}
