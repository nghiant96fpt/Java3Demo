package com.fpoly.java3.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.fpoly.java3.dao.CategoryInterface;
import com.fpoly.java3.models.CategoryModel;

public class CategoryDAO implements CategoryInterface {

	@Override
	public ArrayList<CategoryModel> findAll() {
		ArrayList<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
		try {
			Connection connection = DatabaseHelper.connectDatabase();
			String query = "SELECT * FROM " + TABLE_NAME;

			PreparedStatement statement = connection.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				CategoryModel model = new CategoryModel();
				model.setId(resultSet.getInt(COLUMN_ID));
				model.setName(resultSet.getString(COLUMN_NAME));
				model.setImage(resultSet.getString(COLUMN_IMAGE));
				categoryModels.add(model);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryModels;
	}

	@Override
	public CategoryModel getById(int id) {
		try {
			Connection connection = DatabaseHelper.connectDatabase();
			String query = String.format("SELECT * FROM %s WHERE %s=?", TABLE_NAME, COLUMN_ID);

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CategoryModel model = new CategoryModel();
				model.setId(resultSet.getInt(COLUMN_ID));
				model.setName(resultSet.getString(COLUMN_NAME));
				model.setImage(resultSet.getString(COLUMN_IMAGE));
				connection.close();
				return model;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean insert(CategoryModel model) {
		try {
			Connection connection = DatabaseHelper.connectDatabase();
			String sql = String.format("INSERT INTO %s(%s, %s) VALUES(?, ?)", TABLE_NAME, COLUMN_NAME, COLUMN_IMAGE);

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setString(2, model.getImage());

			return statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CategoryModel model) {
		try {
			Connection connection = DatabaseHelper.connectDatabase();
			String sql = String.format("UPDATE %s SET %s=?, %s=? WHERE %s=?", TABLE_NAME, COLUMN_NAME, COLUMN_IMAGE,
					COLUMN_ID);

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model.getName());
			statement.setString(2, model.getImage());
			statement.setInt(3, model.getId());

			return statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			Connection connection = DatabaseHelper.connectDatabase();
			String sql = String.format("DELETE FROM %s WHERE %s=?", TABLE_NAME, COLUMN_ID);

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			return statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
