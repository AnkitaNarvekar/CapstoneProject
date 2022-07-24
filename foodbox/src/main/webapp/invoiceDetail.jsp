<%@page import="com.foodbox.entities.User"%>
<%
	User user = (User) session.getAttribute("current-user");
System.out.println("User Session is :" + user);
if (user == null) {

	session.setAttribute("message", "You are not logged in !! Login first to access Checkout page");
	response.sendRedirect("login.jsp");
	return;

}
%>

<%@page import="com.foodbox.helper.DbConnectionProvider"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice Page</title>
<%@include file="components/common_css_js.jsp"%>
<link rel="stylesheet"
	href="css/welocmePage_aboutPage_userPage_Foodbox.css">

</head>
<%@include file="components/navbar.jsp"%>
<body>
	<div class="about-section">
		<div class="inner-width">
			<%@include file="components/message.jsp"%>
			<h1 style="color: black !important">
				<b>Payment Page</b>
			</h1>
			<div class="border"></div>
			<div class="about-section-row">
				<div class="about-section-col">
					<div class="about">
						<p>
							<b><h1 style="color: blue;">Your Payment Got successful</h1></b>
						</p>

						<a href="index.jsp" style="color: blue;"><b>For online
								Food Delivery Please visit here...!!</b></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="card-header bg-warning text-white">
			<h1>Your Orders ...!!</h1>
		</div>

		<div class="col-md-12">

			<div class="card mt-3 mb-3">


				<table class="table table-info">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Contact</th>
							<th scope="col">Address</th>
							<th scope="col">DeliveryDate</th>
							<th scope="col">Category</th>
							<th scope="col">DeliveryStatus</th>
							<th scope="col">Payment</th>
							<th scope="col">Amount</th>
							<th scope="col">Time</th>
						</tr>
					</thead>
					<tbody>
						<%
							try {

							String userEmail = request.getParameter("emailId");
							System.out.println("coming Id for Bill Print is: " + userEmail);
							Connection con = DbConnectionProvider.getCon();
							Statement stmt = con.createStatement();
							ResultSet rs = stmt.executeQuery("select *from purchasedrecord where purchase_UserEmail = '" + userEmail + "'");
							while (rs.next()) {
						%>
						<tr>

							<td><%=rs.getString(2)%></td>
							<td><%=rs.getString(3)%></td>
							<td><%=rs.getString(4)%></td>
							<td><%=rs.getString(5)%></td>
							<td><%=rs.getString(6)%></td>
							<td><%=rs.getString(7)%></td>
							<td><%=rs.getString(8)%></td>
							<td><%=rs.getString(9)%></td>
							<td><%=rs.getString(10)%></td>
							<td><%=rs.getString(11)%></td>
						</tr>

						<%
							}

						} catch (Exception e) {
							System.out.println(e);
						}
						%>
					</tbody>


				</table>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="card-header bg-warning text-white">
			<a href="DeleteOrdersCtl?userEmail=<%=user.getUserEmail()%>">
				<h4>
					<b style="color: white;">Click Here to Clear Your Orders </b>
				</h4>
			</a>
		</div>

	</div>
	<!--For Accessing CheckOut Page from directly Cart only -->
	<%@include file="components/common_modals.jsp"%>
</body>

<%@include file="components/footer.jsp"%>
</html>