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

@MultipartConfig()
@WebServlet("/upload-file")
public class UploadFile extends HttpServlet {
	private static final String UPLOAD_DIR = "assets/images";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/admin/upload-file.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String applicationPath = req.getServletContext().getRealPath("");
		String uploadPath = applicationPath + File.separator + UPLOAD_DIR;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		// Get the file part
		Part filePart = req.getPart("image");
		Date date = new Date();
		String fileNameSubmit = date.getTime() + ".jpg";
		String fileName = Paths.get(fileNameSubmit).getFileName().toString();

		// Save file to the directory
		filePart.write(uploadPath + File.separator + fileName);

		System.out.println(uploadPath + File.separator + fileName);

		resp.sendRedirect(String.format("%s/show-image?name=%s", req.getContextPath(), fileName));

//		req.getRequestDispatcher("/views/admin/upload-file.jsp").forward(req, resp);
	}
}
