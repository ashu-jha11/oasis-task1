package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReservationValidation;

@WebServlet("/trainreservationlink")

public class TrainReservationController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String train=req.getParameter("trainNo");
		String classType=req.getParameter("type");
		String journey=req.getParameter("journey");
		String from=req.getParameter("from");
		String to=req.getParameter("to");
		
		int trainNo=Integer.parseInt(train);
		
		ReservationValidation rv=new ReservationValidation();
		rv.validate(trainNo,classType,journey,from,to);
		
		PrintWriter out = resp.getWriter(); 
		out.println("<script type=\"text/javascript\">"); 
		out.println("alert('Reservation added successfully...!!!');"); 
		out.println("location='trainreservation.html';"); 
		out.println("</script>"); 
	}

}
