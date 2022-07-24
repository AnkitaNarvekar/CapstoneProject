package com.foodbox.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodbox.helper.DbConnectionProvider;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class DeleteOrdersCtl
 */
@WebServlet(name = "DeleteOrdersCtl", urlPatterns = { "/DeleteOrdersCtl" })
public class DeleteOrdersCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteOrdersCtl() {
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
		String orderedEmail = request.getParameter("userEmail");
		System.out.println("Coming ID value is:" + orderedEmail);

		try {
			Connection conn = DbConnectionProvider.getCon();
			Statement st = conn.createStatement();

			st.executeUpdate("delete from purchasedrecord where purchase_UserEmail = '" + orderedEmail + "'  ");
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message",
					"Your Order records got deleted Successfully..!! Please remove your selected Items from Your cart and  User Email is: "
							+ orderedEmail);
			response.sendRedirect("invoiceDetail.jsp");
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
