package com.nathcorp.webpro.dto;

public class Products {
private String pname;
private String catagory;
private String seller;
private int price;
private int discount;
private String images;

public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getCatagory() {
	return catagory;
}
public void setCatagory(String catagory) {
	this.catagory = catagory;
}
public String getSeller() {
	return seller;
}
public void setSeller(String seller) {
	this.seller = seller;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public String getImages() {
	return images;
}
public void setImages(String images) {
	this.images = images;
}
}
