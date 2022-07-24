package com.foodbox.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodbox.helper.DbConnectionProvider;

public class UpdateAdminPasswordCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateAdminPasswordCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		try {
			PrintWriter out = response.getWriter();
			HttpSession httpSession = request.getSession();
			String adminEmail = request.getParameter("admin_email");
			String adminPassword = request.getParameter("admin_Newpassword");
			String userType = "admin";

			int check = 0;
			Connection con = DbConnectionProvider.getCon();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *from user where user_email='" + adminEmail + "' ");

			while (rs.next()) {
				check = 1;
				stmt.executeUpdate(
						"update user set user_password='" + adminPassword + "' where user_type='" + userType + "' ");
				httpSession.setAttribute("message", "Admin Password Got Updated");
				response.sendRedirect("admin.jsp");
			}
			if (check == 0) {
				httpSession.setAttribute("message", "There is some Problem ..!! please try again");
				response.sendRedirect("admin.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
