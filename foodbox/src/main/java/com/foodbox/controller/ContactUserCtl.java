package com.foodbox.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.foodbox.entities.ContactUser;
import com.foodbox.helper.FactoryProvider;
import com.foodbox.model.ContactUserDao;

public class ContactUserCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ContactUserCtl() {
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

			String userName = request.getParameter("user_name");
			String userEmail = request.getParameter("user_email");
			String userPhone = request.getParameter("user_phone");
			String userSubject = request.getParameter("subjectOfQuery");
			String userQuery = request.getParameter("yourProblem");

			ContactUser contactUser = new ContactUser();

			contactUser.setUserName(userName);
			contactUser.setUserEmail(userEmail);
			contactUser.setUserPhone(userPhone);
			contactUser.setUserSubject(userSubject);
			contactUser.setUserQuery(userQuery);

			ContactUserDao contactUserDao = new ContactUserDao(FactoryProvider.getFactory());

			int contactUserId = contactUserDao.saveContactUser(contactUser);

			/* For displaying message properly at the VIEW Part */

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message",
					"Your Query Got Submitted Successfully: !!! Contacted User ID is: " + contactUserId);

			response.sendRedirect("contactUS.jsp");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
