package com.nathcorp.webpro.dao;

import com.nathcorp.webpro.dto.Category;
import com.nathcorp.webpro.dto.Products;
import com.nathcorp.webpro.dto.User;

public interface UserDAO {
	public User login(String email, String password);

	public User searchUser(String email);
	public boolean changePassword(String email, String password);
	public boolean registerEmployee(User info);
	public boolean addCategory(Category cat);
	public boolean addProduct(Products pro);

}
