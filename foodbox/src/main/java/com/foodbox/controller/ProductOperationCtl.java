package com.foodbox.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.foodbox.entities.Category;
import com.foodbox.entities.Product;
import com.foodbox.helper.FactoryProvider;
import com.foodbox.model.CategoryDao;
import com.foodbox.model.ProductDao;

//this annotation is used to access video,audio or Images from the Form  
@MultipartConfig
public class ProductOperationCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductOperationCtl() {
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

		PrintWriter out = response.getWriter();

		try {

			/*
			 * With this Servlet we will take task of 2 servlet like: addCategoryServlet and
			 * addProductServlet ...
			 */

			String op = request.getParameter("operation");

			if (op.trim().equals("addcategory")) {

				// add Category Servlet Task
				// Fetching Category Data
				String title = request.getParameter("catTitle");
				String description = request.getParameter("catDescription");

				Category category = new Category();
				category.setCategoryTitle(title);
				category.setCategoryDescription(description);

				// category data database save

				CategoryDao categoryDao = new CategoryDao(FactoryProvider.getFactory());
				int catId = categoryDao.saveCategory(category);

				// out.println("Category data saved in DB: ");
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Category added successfully : " + catId);
				response.sendRedirect("admin.jsp");
				return;

			} else if (op.trim().equals("addproduct")) {

				// add Product Servlet complete Task we will do here

				String pName = request.getParameter("pName");
				String pDesc = request.getParameter("pDesc");
				int pPrice = Integer.parseInt(request.getParameter("pPrice"));
				int pDiscount = Integer.parseInt(request.getParameter("pDiscount"));
				int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
				// System.out.println("Coming Quantity is : " + pQuantity);

				int catId = Integer.parseInt(request.getParameter("catId"));
				// System.out.println("Coming Category ID is : " + catId);

				// Now Receiving Product Pic from View Part by this line of code
				Part part = request.getPart("pPic");

				Product p = new Product();

				p.setpName(pName);
				p.setpDesc(pDesc);
				p.setpPrice(pPrice);
				p.setpDiscount(pDiscount);
				p.setpQuantity(pQuantity);

				// by part.getSubmittedFileName() method we extract name of submitted file/pic
				p.setpPhoto(part.getSubmittedFileName());

				// get Category Object by category id because category data is not part of
				// Product table so storing data of category into product we will do by
				// Following method

				CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
				Category category = cdao.getCategoryById(catId);
				p.setCategory(category);

				// product save
				ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
				pdao.saveProduct(p);

				// product pic upload
				// 1. First Find out the path to upload pic, very first goto till your peoject
				// by using this code of line

				try {
					String path = request.getRealPath("image") + File.separator + "products" + File.separator
							+ part.getSubmittedFileName();
					System.out.println(path);

					// Uploading Image/File Code
					FileOutputStream fos = new FileOutputStream(path);

					InputStream is = part.getInputStream();
					// Reading data by InputStream

					byte[] data = new byte[is.available()];
					is.read(data);

					// Now Writing data by File Output Stream
					fos.write(data);
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				// out.println("product save success....");
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Product is added successfully...");
				response.sendRedirect("admin.jsp");
				return;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
