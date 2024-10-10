package com.fpoly.java3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fpoly.java3.beans.User;
import com.fpoly.java3.database.DatabaseHelper;

// Root path

@WebServlet("/")
public class HomePage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Connection connection = DatabaseHelper.connectDatabase();
			System.out.println(connection.getMetaData().getDatabaseProductVersion());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.setCharacterEncoding("utf-8");

		req.setAttribute("title", "Lập trình java 5");

		ArrayList<String> classArrayList = new ArrayList<String>();
		classArrayList.add("SD19301");
		classArrayList.add("SD19302");
		classArrayList.add("SD19303");

		req.setAttribute("className", classArrayList);

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Nguyen Trong Nghia");
		map.put("code", "PC12345");

		req.setAttribute("info", map);

		// Beans Class
		User user = new User();
		user.setCode("PC123456");
		user.setName("Nguyen Van A");
		user.setClassName("SD19303");
		user.setPhoneNumberString("0987654321");

//		Gui qua attribute tu request

		req.setAttribute("user", user);

//		{
//			"key": "value"
//		}

		// protocal

		// http
//		System.out.println(req.getProtocol());
//		// 8080
//		System.out.println(req.getServerPort());
//		// localhost
//		System.out.println(req.getServerName());
//		// /home
//		System.out.println(req.getServletPath());
//		// GET
//		System.out.println(req.getMethod());
//		// username=abc
//		// password=123
//		System.out.println(req.getQueryString());
//		// abc
//		System.out.println(req.getParameter("username"));

		req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
	}
}
