package com.nathcorp.webpro.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nathcorp.webpro.dto.Category;
import com.nathcorp.webpro.dto.Products;
import com.nathcorp.webpro.dto.User;

public class UserDaoImpl implements UserDAO {
	private static final String URL="jdbc:mysql://localhost:3306/product?user=root&password=root";
	private static final String DRIVER_CLASS_NAME="com.mysql.jdbc.Driver";
	private static final String SELECT_SQL="select * from login where email=? and password=?";
	private static final String SELECT_SQL2="select * from login where email=?";
	private static final String SELECT_SQL1="select max(cid) from catagories";
	private static final String INSERT_SQL="insert  into login values(?,?,?,?,?)";
	private static final String INSERT_SQL1="insert  into catagories values(?,?,?)";
	private static final String INSERT_SQL2="insert  into products values(?,?,?,?,?,?)";
	private static final String UPDATE_SQL="update login set password=? where email=?";
	@Override
	
	public User login(String email, String password) {
		//String sql="select * from employee_info where id=? and password=?";
		try {
			Class.forName(DRIVER_CLASS_NAME);

				try (Connection conn=DriverManager.getConnection(URL);
						PreparedStatement pstmt=conn.prepareStatement(SELECT_SQL)){

					pstmt.setString(1, email);
					pstmt.setString(2, password);
					try(ResultSet rs=pstmt.executeQuery()){
						if(rs.next()) {
							User info=new User();
						
						
							info.setEmail(rs.getString("email"));
						info.setPassword(rs.getString("password"));

							return info;
						}else {
							return null;
						}
					}
				}
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}

			} 

//		User info=searchUser(email);
//		pstmt.setString(1, email);
//		System.out.println(info);
//		if(info==null) {
//			String pass=info.getPassword();
//			if(pass.equals(password)) {
//				return info;
//			}else {
//				return null;
//			}
//		}
//		return null;
//	}

	@Override
	public User searchUser(String email) {
		try {
			Class.forName(DRIVER_CLASS_NAME);

				try (Connection conn=DriverManager.getConnection(URL);
						PreparedStatement pstmt=conn.prepareStatement(SELECT_SQL2)){

					pstmt.setString(1, email);

					try(ResultSet rs=pstmt.executeQuery()){
						if(rs.next()) {
							User info=new User();
						
							info.setName(rs.getString("name"));
							info.setEmail(rs.getString("email"));
							info.setAddress(rs.getString("address"));
							info.setPhone(rs.getString("phone"));
						

							return info;
						}else {
							return null;
						}
					}
				}
				}catch(Exception e) {
					e.printStackTrace();
					return null;
				}

			} 

	@Override
	public boolean changePassword(String email, String password) {
		
		try {
			Class.forName(DRIVER_CLASS_NAME);
			try(Connection conn=DriverManager.getConnection(URL);
					PreparedStatement pstmt=conn.prepareStatement(UPDATE_SQL)){
				pstmt.setString(1, password);
				pstmt.setString(2, email);
				int count=pstmt.executeUpdate();
				boolean check=count>0?true:false; 
				return check;
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;

		}
	}
	
	@Override
	public boolean registerEmployee(User info) {
		try {

			Class.forName(DRIVER_CLASS_NAME);
			try(Connection conn=DriverManager.getConnection(URL);
					PreparedStatement pstmt=conn.prepareStatement(INSERT_SQL)){

			
				pstmt.setString(1,info.getName());
				pstmt.setString(2, info.getEmail());
				pstmt.setString(3, info.getPassword());
				pstmt.setString(4, info.getAddress());
				pstmt.setString(5, info.getPhone());

				int count=pstmt.executeUpdate();
				if(count>0) {
					return true;
				}else {
					return false;
				}
			}



		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean addCategory(Category cat) {
		try {

			Class.forName(DRIVER_CLASS_NAME);
			try(Connection conn=DriverManager.getConnection(URL);
					PreparedStatement pstmt=conn.prepareStatement(INSERT_SQL1)){
				
                  //   ResultSet rs=pstmt.executeQuery("SELECT MAX(cid) AS cid FROM catagories");
                    // int lastid = rs.getInt("cid");
//					
//						int id=0;
//						if(rs.last()){
//						id=rs.getInt("cid");
//						}
//						PrintWriter out = null;
//						out.println("Last inserted Id: "+id);
				
				pstmt.setInt(1,cat.getCid());
				pstmt.setString(2,cat.getCategory());
				pstmt.setString(3,cat.getImage());
				
				
				int count=pstmt.executeUpdate();
				if(count>0) {
					return true;
				}else {
					return false;
				}
			}

			
		

		}catch(Exception e) {
			e.printStackTrace();
		return false;
	}
	}

	@Override
	public boolean addProduct(Products pro) {
		try {

			Class.forName(DRIVER_CLASS_NAME);
			try(Connection conn=DriverManager.getConnection(URL);
					PreparedStatement pstmt=conn.prepareStatement(INSERT_SQL2)){
				
                 pstmt.setString(1, pro.getPname());
			
				pstmt.setString(2,pro.getCatagory());
				pstmt.setString(3,pro.getSeller());
				pstmt.setInt(4, pro.getPrice());
				pstmt.setInt(5,pro.getDiscount());
				pstmt.setString(6, pro.getImages());
				
				int count=pstmt.executeUpdate();
				if(count>0) {
					return true;
				}else {
					return false;
				}
			}

			
		

		}catch(Exception e) {
			e.printStackTrace();
		return false;
	}
	}
	

}