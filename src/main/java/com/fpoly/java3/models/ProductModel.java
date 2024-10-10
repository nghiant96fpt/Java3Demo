package com.fpoly.java3.models;

import java.util.ArrayList;

//Entity
public class ProductModel {
	private int id;
	private String desc;
	private String name;
	private int price;
	private CategoryModel categoryModel;
	private ArrayList<ImageModel> images;

	public ArrayList<ImageModel> getImages() {
		return images;
	}

	public void setImages(ArrayList<ImageModel> images) {
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

}
