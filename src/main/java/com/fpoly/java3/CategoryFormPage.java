package com.fpoly.java3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fpoly.java3.database.CategoryDAO;
import com.fpoly.java3.models.CategoryModel;

@MultipartConfig()
@WebServlet("/category-form")
public class CategoryFormPage extends HttpServlet {
	private static final String UPLOAD_DIR = "assets/images";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
//			Lấy cat info từ DB 

			CategoryDAO categoryDAO = new CategoryDAO();
			CategoryModel model = categoryDAO.getById(id);

			req.setAttribute("cat", model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/admin/category-form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");

		String applicationPath = req.getServletContext().getRealPath("");
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		Part filePart = req.getPart("image");
		Date date = new Date();
		String fileNameSubmit = date.getTime() + ".jpg";
		String fileName = Paths.get(fileNameSubmit).getFileName().toString();
		filePart.write(uploadPath + File.separator + fileName);

		CategoryModel categoryModel = new CategoryModel();
		categoryModel.setName(name);
		categoryModel.setImage(fileName);

		CategoryDAO categoryDAO = new CategoryDAO();

		if (!id.equals("")) {
			try {
				categoryModel.setId(Integer.parseInt(id));
				categoryDAO.update(categoryModel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			categoryDAO.insert(categoryModel);
		}

		resp.sendRedirect(req.getContextPath() + "/categories");

//		req.getRequestDispatcher("/views/admin/category-form.jsp").forward(req, resp);
	}
}
