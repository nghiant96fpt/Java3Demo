package com.fpoly.java3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java3.database.CategoryDAO;
import com.fpoly.java3.database.ProductDAO;
import com.fpoly.java3.models.CategoryModel;

@WebServlet("/categories")
public class CategoriesPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	CategoryDAO categoryDAO = new CategoryDAO();
	ArrayList<CategoryModel> categoryModels = categoryDAO.findAll();

	req.setAttribute("categories", categoryModels);

	ProductDAO productDAO = new ProductDAO();
	productDAO.findAll();

	req.getRequestDispatcher("/views/admin/categories.jsp").forward(req, resp);
    }
}
