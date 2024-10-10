package com.fpoly.java3.dao;

import java.util.ArrayList;

import com.fpoly.java3.models.CategoryModel;

public interface CategoryInterface {
	String TABLE_NAME = "categories";
	String COLUMN_ID = "id";
	String COLUMN_NAME = "name";
	String COLUMN_IMAGE = "image";

	public ArrayList<CategoryModel> findAll();

	public CategoryModel getById(int id);

	public boolean insert(CategoryModel model);

	public boolean update(CategoryModel model);

	public boolean delete(int id);
}
