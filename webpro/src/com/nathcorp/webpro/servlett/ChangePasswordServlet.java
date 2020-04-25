package com.nathcorp.webpro.servlett;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nathcorp.webpro.dao.UserDAO;
import com.nathcorp.webpro.dto.User;
import com.nathcorp.webpro.util.UserDaoManager;


@SuppressWarnings("serial")
@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
HttpSession session=req.getSession(false);
if(session!=null)
{
	String pass=req.getParameter("password");
	String confirmPass=req.getParameter("confirmPassword");
	
	if(pass.equals(confirmPass)) {
		User info=(User) session.getAttribute("info");
	UserDAO dao=UserDaoManager.getEmployeeDAO();
	dao.changePassword(info.getEmail(), pass);
	RequestDispatcher dispatcher=req.getRequestDispatcher("./home");
	dispatcher.forward(req, resp);
	}else {
		String msg="Password not matching";
		req.setAttribute("msg",msg);
		RequestDispatcher dispatcher=req.getRequestDispatcher("./changepassword.jsp");
		dispatcher.forward(req, resp);
		
	}
}else {
	RequestDispatcher dispatcher=req.getRequestDispatcher("./login.jsp");
	dispatcher.forward(req, resp);
}
	
	



}//end of do post
}//end of LoginServlet
