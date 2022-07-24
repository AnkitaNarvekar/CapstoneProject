package com.foodbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodbox.entities.User;
import com.foodbox.helper.FactoryProvider;
import com.foodbox.model.UserDao;

/**
 * Servlet implementation class LoginCtl
 */
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		try {
			PrintWriter out = response.getWriter();
			HttpSession httpSession = request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			UserDao userDao = new UserDao(FactoryProvider.getFactory());
			User user = userDao.getUserByEmailAndPassword(email, password);
			// System.out.println(user);

			if (user == null) {
				// out.println("<h1> Invalid User Details ...!! </h1>");
				httpSession.setAttribute("message", "Invalid Details !! Try with amother one ");
				response.sendRedirect("login.jsp");
				return;
			} else {
				// out.println("<h1>Welcome "+ user.getUserName()+" ...!! </h1>");
				/*
				 * in this section we will redirect to two pages 1. admin.jsp 2.
				 * normalUserLogin.jsp Because, in this application we have two tyes of user-
				 * admin and normal User
				 */

				// save logged in data by HttpSession's Object

				httpSession.setAttribute("current-user", user);
				if (user.getUserType().equals("admin")) {
					// admin :-admin.jsp
					response.sendRedirect("admin.jsp");
				} else if (user.getUserType().equals("normal")) {
					// normal :-normal.jsp
					response.sendRedirect("normalUser.jsp");
				} else {
					out.println("<h1> We have not identified User Type...!! Please try Again</h1>");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
