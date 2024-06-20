package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginValidation;

@WebServlet("/loginlink")

public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		
		LoginValidation lv=new LoginValidation();
		boolean status=lv.validate(user,pass);
		
//		req.setAttribute("user", user);
		
		if (status) {
			RequestDispatcher rd=req.getRequestDispatcher("userhome.html");
			rd.forward(req, resp);
		}else {
			resp.sendRedirect("login.html");
		}
	}

}
