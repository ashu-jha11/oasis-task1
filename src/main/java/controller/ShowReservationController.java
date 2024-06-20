package controller;

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

@WebServlet("/showreservationlink")

public class ShowReservationController extends HttpServlet{
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	String query="select * from reservation";
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/oasis","root","sql@123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			
			pw.print("<table width=50% border=2>");
			pw.print("<caption>Train Reservation Details</caption>");
			
            ResultSetMetaData rsmd = rs.getMetaData ();
            int total = rsmd.getColumnCount ();
            
			pw.print ("<tr>");
            for (int i = 1; i <= total; i++)
         {
             pw.print ("<th>" + rsmd.getColumnName (i) + "</th>");
         }
            pw.print ("</tr>");
			
			while (rs.next()) {
				pw.print ("<tr><td>" + rs.getInt (1) + "</td><td>" +  rs.getInt (2) + " </td><td>" + rs.getString (3) + "</td><td>"
						+ rs.getString (4) +"</td><td>"+ rs.getString (5) + "</td><td>" + rs.getString (6)+ "</td></tr>");
			}
			pw.print("<table>");
			rs.close(); 
            stmt.close(); 
            pw.close(); 
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy() { 
        try { 
            con.close(); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    }

}
