<%@page import="com.foodbox.helper.Helper"%>
<%@page import="com.foodbox.entities.Category"%>
<%@page import="com.foodbox.model.CategoryDao"%>
<%@page import="com.foodbox.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.foodbox.model.ProductDao"%>
<%@page import="com.foodbox.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Foodbox Home Page</title>
<%@include file="components/common_css_js.jsp"%>

</head>
<body>

	<%@include file="components/navbar.jsp"%>

	<!-- For Showing Complete data into center  -->
	<div class="container-fluid">

		<div class="row mt-3 mx-2">

			<%
				String cat = request.getParameter("category");
			//out.println(cat);

			ProductDao dao = new ProductDao(FactoryProvider.getFactory());
			List<Product> list = null;

			 if (cat == null || cat.trim().equals("all")) {
				list = dao.getAllProducts();

			} else {

				int cid = Integer.parseInt(cat.trim());
				list = dao.getAllProductsById(cid);

			}

			CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
			List<Category> clist = cdao.getCategories();
			%>

			<!-- Show Categories  -->
			<div class="col-md-2">

				<div class="list-group mt-4">

					<a href="index.jsp?category=all"
						class="list-group-item list-group-item-action active"> All
						Products </a>


					<%
						for (Category c : clist) {
					%>

					<a href="index.jsp?category=<%=c.getCategoryId()%>"
						class="list-group-item list-group-item-action"><h5
							style="color: #01579b"><%=c.getCategoryTitle()%></h5></a>

					<%
						}
					%>

				</div>

			</div>

			<!-- Show Products  -->
			<div class="col-md-10">
				<!-- Row -->

				<div class="row mt-4">

					<!-- Column:12 for Product -->
					<div class="col-md-12">

						<div class="card-columns">

							<!-- Traversing Products -->
							<%
								for (Product p : list) {
							%>

							<!-- Product Card -->
							<div class="card product-card">

								<div class="container text-center">

									<img src="image/products/<%=p.getpPhoto()%>"
										style="max-height: 200px; max-width: 100%; width: auto;"
										class="card-img-top m-2">

								</div>

								<div class="card-body">
									<h5 class="card-title"><%=p.getpName()%></h5>
									<p class="card-text">
										<!--p.getpDesc()c() %> -->
										<%=Helper.get10Words(p.getpDesc())%>
									</p>
								</div>

								<div class="card-footer text-center">
									<button class="btn bg-info text-white"
										onclick="add_to_cart(<%=p.getpId()%> , '<%=p.getpName()%>', <%=p.getPriceAfterApplyingDiscount()%>)">Add
										to Cart</button>
									<button class="btn btn-outline-success">
										&#8377;<%=p.getPriceAfterApplyingDiscount()%>/- <span
											class="text-secondary discount-label">&#8377; <%=p.getpPrice()%>
											, <%=p.getpDiscount()%>% off
										</span>
									</button>

								</div>
							</div>




							<%
								}
							if (list.size() == 0) {

								out.println("<h3>No items available for this category</h3>");
							}
							%>


						</div>


					</div>

				</div>
			</div>

		</div>
	</div>

	<%@include file="components/common_modals.jsp"%>

</body>

<%@include file="components/footer.jsp"%>
</html>