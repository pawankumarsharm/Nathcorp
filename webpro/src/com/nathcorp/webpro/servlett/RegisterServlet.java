package com.nathcorp.webpro.servlett;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nathcorp.webpro.dao.UserDAO;
import com.nathcorp.webpro.dto.User;
import com.nathcorp.webpro.util.UserDaoManager;


@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String name=req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	String confirmPassword=req.getParameter("confirmPassword");
	String address=req.getParameter("address");
	String phone=req.getParameter("phone");
	

	if(password.equals(confirmPassword)) {
				User info=new User();
				
				info.setName(name);
				info.setEmail(email);
				info.setPassword(password);
				info.setConfirmPassword(confirmPassword);
				info.setAddress(address);
				info.setPhone(phone);
				
				UserDAO dao=UserDaoManager.getEmployeeDAO();
				
			boolean check=dao.registerEmployee(info);
				
				
			String msg="";
			if(check) {
				msg="Registration Compleated";
				
			}else {
				msg="Id cannot be repeated";
				}
				
			req.setAttribute("msg", msg);
			RequestDispatcher dispatcher= req.getRequestDispatcher("./login.jsp");
			dispatcher.forward(req, resp);
	}else {
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<h4 style='color:Red'>password not matching with confirm password</h4>");
		out.println("</html>");
		out.println(password);
		out.println(confirmPassword);
	}
	
	




}//end of doPost
}//end of LoginServlet
