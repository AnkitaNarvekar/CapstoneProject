package com.foodbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.foodbox.entities.User;
import com.foodbox.helper.FactoryProvider;

/**
 * Servlet implementation class RegisterCtl
 */
@WebServlet(name = "RegisterCtl", urlPatterns = { "/RegisterCtl" })
public class RegisterCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterCtl() {
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
		// doGet(request, response);

		try {
			PrintWriter out = response.getWriter();

			String userName = request.getParameter("user_name");
			String userEmail = request.getParameter("user_email");
			String userPassword = request.getParameter("user_password");
			String userPhone = request.getParameter("user_phone");
			String userAddress = request.getParameter("user_address");

			/* SERVER side validations, We can do here */
			if (userName.isEmpty()) {

				out.print("<html><body><h1> Name can not be blank\n </h1></body></html>");
				return;

			}

			/* Creating User object to store the data in DB */
			User user = new User(userName, userEmail, userPassword, userPhone, "default.jpg", userAddress, "normal");

			/*
			 * Now Saving Data in Hibernate....!!! Steps for this will be ---- 1. Create
			 * Hibernate Session 2. Create Transaction Object and Begin Transaction 3.
			 * Perform Save operation so that Data should saved in DB 4. Commit the
			 * Transaction 5. Close the Hibernate Session
			 */
			Session hibernateSession = FactoryProvider.getFactory().openSession();

			Transaction tx = hibernateSession.beginTransaction();
			int userId = (int) hibernateSession.save(user);

			tx.commit();
			hibernateSession.close();

			/*
			 * out.print("<html><body><h1>Successfully Data Saved in DB:</h1></body></html>"
			 * ); out.print("<html><body><h1><br>User id is: "+userId +
			 * "</h1></body></html>");
			 */

			/* For displaying message properly at the VIEW Part */

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Registration Successful: !!! User ID is: " + userId);

			response.sendRedirect("register.jsp");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
