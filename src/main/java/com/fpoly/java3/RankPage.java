package com.fpoly.java3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rank")
public class RankPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/rank.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			float point = Float.parseFloat(req.getParameter("point"));

			if (point < 0 || point > 10) {
				req.setAttribute("error", "Diem phai nam trong khoan tu 0 den 10");
			}

			req.setAttribute("point", point);

		} catch (Exception e) {
			req.setAttribute("error", "Khong dung dinh dang");
		}

		req.getRequestDispatcher("/views/rank.jsp").forward(req, resp);
	}
}
