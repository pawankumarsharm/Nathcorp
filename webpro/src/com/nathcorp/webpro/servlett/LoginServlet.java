package com.nathcorp.webpro.servlett;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nathcorp.webpro.dao.UserDAO;
import com.nathcorp.webpro.dto.User;
import com.nathcorp.webpro.util.UserDaoManager;

@SuppressWarnings("serial")
@WebServlet("/loginn")
public class LoginServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String email=req.getParameter("email");
String password=req.getParameter("password");

String rememberMe=req.getParameter("rememberme");
if(rememberMe==null) {
	Cookie[] cookies=req.getCookies();
	if(cookies!=null) {
	for (Cookie cookie : cookies) {
		if(cookie.getName().equals("alwaysRemember")) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
	}
	}
}else {
	Cookie cookie=new Cookie("alwaysRemember", email+"");
	resp.addCookie(cookie);
}

UserDAO dao=UserDaoManager.getEmployeeDAO();

User info=dao.login(email, password);

if(info==null) {
	PrintWriter out=resp.getWriter();
	out.println("<html>");
	out.println("<h4 style='color:Red'>invalid id or password</h4>");
	out.println("</html>");
	
	RequestDispatcher dispatcher=req.getRequestDispatcher("/login.jsp");
	dispatcher.include(req, resp);
}else {
	HttpSession session=req.getSession();
	session.setAttribute("information",info);
	RequestDispatcher dispatcher=req.getRequestDispatcher("/home");
	dispatcher.forward(req, resp);
}



}//end of do post
}//end of LoginServlet
