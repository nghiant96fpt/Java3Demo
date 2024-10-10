package com.fpoly.java3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java3.database.CategoryDAO;

@WebServlet("/delete-category")
public class DeleteCategoryPage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		CategoryDAO categoryDAO = new CategoryDAO();

		categoryDAO.delete(Integer.parseInt(id));

		resp.sendRedirect(req.getContextPath() + "/categories");
	}
}
