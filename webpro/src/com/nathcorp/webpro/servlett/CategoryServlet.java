package com.nathcorp.webpro.servlett;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathcorp.webpro.dao.UserDAO;
import com.nathcorp.webpro.dto.Category;
import com.nathcorp.webpro.util.UserDaoManager;

@SuppressWarnings("serial")
public class CategoryServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid=Integer.parseInt(req.getParameter("cid"));
		String catagory=req.getParameter("catagory");
		String image=req.getParameter("image");
		
		Category cat=new Category();
		
		cat.setCid(cid);
		cat.setCategory(catagory);
		cat.setImage(image);
		
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
			Cookie cookie=new Cookie("alwaysRemember", cid+"");
			resp.addCookie(cookie);
		}
		
	
		UserDAO dao=UserDaoManager.getEmployeeDAO();
		
	boolean check=dao.addCategory(cat);
	String msg="";
	if(check) {
		msg="Product added successfully";
		
	}else {
		msg="something went wrong";
		}
	req.setAttribute("msg", msg);
	RequestDispatcher dispatcher= req.getRequestDispatcher("./categories.jsp");
	dispatcher.forward(req, resp);
	}
}
