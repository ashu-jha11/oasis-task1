package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RegistrationValidation;

@WebServlet("/registerlink")

public class RegistrationController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String ag=req.getParameter("age");
		String ph=req.getParameter("phno");
		String pass=req.getParameter("pass");
		
		int age=Integer.parseInt(ag);
		int phno=Integer.parseInt(ph);
		
		RegistrationValidation rv=new RegistrationValidation();
		rv.validate(user,email,gender,age,phno,pass);
		
		resp.sendRedirect("login.html");
	}

}
