package com.fpoly.java3.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fpoly.java3.dao.ProductInterface;
import com.fpoly.java3.models.CategoryModel;
import com.fpoly.java3.models.ImageModel;
import com.fpoly.java3.models.ProductModel;

public class ProductDAO implements ProductInterface {

    @Override
    public ArrayList<ProductModel> findAll() {
	ArrayList<ProductModel> productModels = new ArrayList<ProductModel>();
	try {
	    Connection connection = DatabaseHelper.connectDatabase();

	    String sql = String.format(
		    "SELECT p.%s AS product_id, p.%s AS product_name, p.%s AS description, p.%s AS price, "
			    + "c.%s AS category_id, c.%s AS category_name, c.%s AS category_image, "
			    + "img.%s AS image_name FROM %s p JOIN %s c ON p.%s = c.%s JOIN ("
			    + "SELECT %s, MIN(%s) AS name FROM %s GROUP BY %s) img ON p.%s = img.%s",
		    PRODUCT_COLUMN_ID, PRODUCT_COLUMN_NAME, PRODUCT_COLUMN_DESC, PRODUCT_COLUMN_PRICE,
		    CategoryDAO.COLUMN_ID, CategoryDAO.COLUMN_NAME, CategoryDAO.COLUMN_IMAGE, IMAGE_COLUMN_NAME,
		    PRODUCT_TABLE_NAME, CategoryDAO.TABLE_NAME, PRODUCT_COLUMN_CAT_ID, CategoryDAO.COLUMN_ID,
		    IMAGE_COLUMN_PROD_ID, IMAGE_COLUMN_NAME, IMAGE_TABLE_NAME, IMAGE_COLUMN_PROD_ID, PRODUCT_COLUMN_ID,
		    IMAGE_COLUMN_PROD_ID);

	    System.out.println(sql);

	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
		int productID = resultSet.getInt("product_id");
		String productName = resultSet.getString("product_name");
		String productDescription = resultSet.getString("description");
		int productPrice = resultSet.getInt("price");

		int categoryID = resultSet.getInt("category_id");
		String categoryName = resultSet.getString("category_name");
		String categoryImage = resultSet.getString("category_image");

		String imageName = resultSet.getString("image_name");

		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setId(categoryID);
		categoryModel.setName(categoryName);
		categoryModel.setImage(categoryImage);

		ArrayList<ImageModel> imageModels = new ArrayList<ImageModel>();
		ImageModel imageModel = new ImageModel();
		imageModel.setName(imageName);
		imageModels.add(imageModel);

		ProductModel productModel = new ProductModel();
		productModel.setId(productID);
		productModel.setName(productName);
		productModel.setDesc(productDescription);
		productModel.setPrice(productPrice);
		productModel.setCategoryModel(categoryModel);
		productModel.setImages(imageModels);

		productModels.add(productModel);
	    }

	} catch (Exception e) {

	}
	return productModels;
    }

    @Override
    public boolean insert(ProductModel productModel) {
	try {
	    Connection connection = DatabaseHelper.connectDatabase();

	    String insertProduct = String.format("INSERT INTO %s(%s, %s, %s, %s) VALUES(?, ?, ?, ?)",
		    PRODUCT_TABLE_NAME, PRODUCT_COLUMN_DESC, PRODUCT_COLUMN_NAME, PRODUCT_COLUMN_PRICE,
		    PRODUCT_COLUMN_CAT_ID);

	    PreparedStatement statement = connection.prepareStatement(insertProduct,
		    PreparedStatement.RETURN_GENERATED_KEYS);
	    statement.setString(1, productModel.getDesc());
	    statement.setString(2, productModel.getName());
	    statement.setInt(3, productModel.getPrice());
	    statement.setInt(4, productModel.getCategoryModel().getId());

	    int prodId = statement.executeUpdate();

	    for (ImageModel imageModel : productModel.getImages()) {
		String insertImage = String.format("INSERT INTO %s(%s, %s) VALUES(?, ?)", IMAGE_TABLE_NAME,
			IMAGE_COLUMN_NAME, IMAGE_COLUMN_PROD_ID);
		PreparedStatement statementImage = connection.prepareStatement(insertImage);
		statementImage.setString(1, imageModel.getName());
		statementImage.setInt(2, prodId);

		statementImage.execute();

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return false;
    }

    @Override
    public boolean update(ProductModel productModel) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean delete(int idProd) {
	try {
	    Connection connection = DatabaseHelper.connectDatabase();

	    String deleteImage = String.format("DELETE FORM %s WHERE %s=?", IMAGE_TABLE_NAME, IMAGE_COLUMN_PROD_ID);

	    PreparedStatement statementImage = connection.prepareStatement(deleteImage);
	    statementImage.setInt(1, idProd);
	    statementImage.execute();

	    String deleteProd = String.format("DELETE FORM %s WHERE %s=?", PRODUCT_TABLE_NAME, PRODUCT_COLUMN_ID);
	    PreparedStatement statementProd = connection.prepareStatement(deleteProd);
	    statementProd.setInt(1, idProd);
	    statementProd.execute();

	} catch (Exception e) {

	}
	return false;
    }

    @Override
    public ProductModel getById(int idProd) {
	try {
	    Connection connection = DatabaseHelper.connectDatabase();

//			lấy thông tin sản phẩm theo id 
//			Lấy danh sách hình ảnh theo prod_id

	    String selectProduct = String.format("SELECT * FROM %s WHERE %s=?", PRODUCT_TABLE_NAME, PRODUCT_COLUMN_ID);

	    PreparedStatement statementProd = connection.prepareStatement(selectProduct);

	    ResultSet resultSetProd = statementProd.executeQuery();
	    ProductModel product = new ProductModel();

	    while (resultSetProd.next()) {

	    }

	    String selectImages = String.format("SELECT * FROM %s WHERE %s=?", IMAGE_TABLE_NAME, IMAGE_COLUMN_PROD_ID);

	} catch (Exception e) {
	    // TODO: handle exception
	}
	return null;
    }

}
