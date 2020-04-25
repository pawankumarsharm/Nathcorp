package com.nathcorp.webpro.servlett;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nathcorp.webpro.dao.UserDAO;
import com.nathcorp.webpro.dto.User;
import com.nathcorp.webpro.util.UserDaoManager;



@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	
	if(session==null) {
		RequestDispatcher dispatcher=req.getRequestDispatcher("/login.jsp");
		dispatcher.forward(req, resp);
	}else {
	String email=req.getParameter("email");
	
	UserDAO dao=UserDaoManager.getEmployeeDAO();
	User info=dao.searchUser(email);
	
	req.setAttribute("info", info);
	RequestDispatcher dispatcher=req.getRequestDispatcher("/search.jsp");
	dispatcher.forward(req, resp);
	}
}//end of doGet

}//end of LoginServlet
