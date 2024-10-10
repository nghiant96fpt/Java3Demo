package com.fpoly.java3.dao;

import java.util.ArrayList;

import com.fpoly.java3.models.ProductModel;

public interface ProductInterface {
	String PRODUCT_TABLE_NAME = "products";
	String PRODUCT_COLUMN_ID = "id";
	String PRODUCT_COLUMN_DESC = "description";
	String PRODUCT_COLUMN_NAME = "name";
	String PRODUCT_COLUMN_PRICE = "price";
	String PRODUCT_COLUMN_CAT_ID = "cat_id";

	String IMAGE_TABLE_NAME = "images";
	String IMAGE_COLUMN_ID = "id";
	String IMAGE_COLUMN_PROD_ID = "prod_id";
	String IMAGE_COLUMN_NAME = "name";

	ArrayList<ProductModel> findAll();

	boolean insert(ProductModel productModel);

	boolean update(ProductModel productModel);

	boolean delete(int idProd);

	ProductModel getById(int idProd);

}
