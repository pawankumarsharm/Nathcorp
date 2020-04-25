package com.nathcorp.webpro.util;

import com.nathcorp.webpro.dao.UserDAO;
import com.nathcorp.webpro.dao.UserDaoImpl;

public class UserDaoManager {
	private UserDaoManager() {}
	public static UserDAO getEmployeeDAO() {
		
		return new UserDaoImpl();
}
}
