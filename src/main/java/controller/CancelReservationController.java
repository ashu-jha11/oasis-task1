package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CancelValidation;

@WebServlet("/cancelreservationlink")

public class CancelReservationController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pnr=req.getParameter("pnrNo");
		
		int pnrNo=Integer.parseInt(pnr);
		
		CancelValidation cv=new CancelValidation();
		cv.validate(pnrNo);
		
		PrintWriter out = resp.getWriter(); 
		out.println("<script type=\"text/javascript\">"); 
		out.println("alert('Reservation canceled successfully...!!!');"); 
		out.println("location='cancelreservation.html';"); 
		out.println("</script>");
	}

}
