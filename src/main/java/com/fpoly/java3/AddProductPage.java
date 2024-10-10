package com.fpoly.java3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.fpoly.java3.database.CategoryDAO;
import com.fpoly.java3.database.ProductDAO;
import com.fpoly.java3.models.CategoryModel;
import com.fpoly.java3.models.ImageModel;
import com.fpoly.java3.models.ProductModel;

@MultipartConfig
@WebServlet("/add-product")
public class AddProductPage extends HttpServlet {
    private static final String UPLOAD_DIR = "assets/images";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	req.setAttribute("cat", this.getCategories());
	req.getRequestDispatcher("/views/admin/add-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Collection<Part> parts = req.getParts();
	List<Part> images = parts.stream().toList();

	String name = req.getParameter("name");
	int price = Integer.parseInt(req.getParameter("price"));
	String desc = req.getParameter("decs");
	int categoryId = Integer.parseInt(req.getParameter("category"));

	ArrayList<ImageModel> imageModels = new ArrayList<ImageModel>();

	String applicationPath = req.getServletContext().getRealPath("");
	String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
	File uploadDir = new File(uploadPath);
	if (!uploadDir.exists()) {
	    uploadDir.mkdir();
	}

	for (Part imagePart : images) {
	    Date date = new Date();
	    String fileNameSubmit = date.getTime() + ".jpg";
	    String fileName = Paths.get(fileNameSubmit).getFileName().toString();
	    imagePart.write(uploadPath + File.separator + fileName);

	    ImageModel model = new ImageModel();
	    model.setName(fileName);
	    imageModels.add(model);
	}

	ProductDAO productDAO = new ProductDAO();

	ProductModel productModel = new ProductModel();
	productModel.setName(name);
	productModel.setDesc(desc);
	productModel.setPrice(price);

	CategoryDAO categoryDAO = new CategoryDAO();

	productModel.setCategoryModel(categoryDAO.getById(categoryId));
	productModel.setImages(imageModels);

	productDAO.insert(productModel);

	req.setAttribute("cat", this.getCategories());
	req.getRequestDispatcher("/views/admin/add-product.jsp").forward(req, resp);
    }

    private ArrayList<CategoryModel> getCategories() {
	CategoryDAO categoryDAO = new CategoryDAO();
	return categoryDAO.findAll();
    }
}
