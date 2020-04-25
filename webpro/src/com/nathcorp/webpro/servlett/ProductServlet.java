package com.nathcorp.webpro.servlett;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nathcorp.webpro.dao.UserDAO;
import com.nathcorp.webpro.dto.Products;
import com.nathcorp.webpro.util.UserDaoManager;

@SuppressWarnings("serial")
public class ProductServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pname=req.getParameter("pname");
		String catagory=req.getParameter("catagory");
		String seller=req.getParameter("seller");
		int price=Integer.parseInt(req.getParameter("price"));
		int discount=Integer.parseInt(req.getParameter("discount"));
		String images=req.getParameter("images");
		
		Products pro=new Products();
		
		pro.setPname(pname);
		pro.setCatagory(catagory);
		pro.setSeller(seller);
		pro.setPrice(price);
		pro.setDiscount(discount);
		pro.setImages(images);
		
	
		UserDAO dao=UserDaoManager.getEmployeeDAO();
		
	boolean check=dao.addProduct(pro);
	String msg="";
	if(check) {
		msg="Product added successfully";
		
	}else {
		msg="something went wrong";
		}
	req.setAttribute("msg", msg);
	RequestDispatcher dispatcher= req.getRequestDispatcher("./products.jsp");
	dispatcher.forward(req, resp);
	}
}
