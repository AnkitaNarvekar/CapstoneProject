<%@page import="com.foodbox.helper.DbConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Report</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="row text-center">
		<div class="col-md-11">

			<div class="card mt-3">
				<%@include file="components/message.jsp"%>


				<table class="table table-bordered">
					<thead>
						<tr>
							<th scope="col">PurchaseId</th>
							<th scope="col">User</th>
							<th scope="col">Email</th>
							<th scope="col">Phone</th>
							<th scope="col">Address</th>
							<th scope="col">Date</th>
							<th scope="col">Category</th>
							<th scope="col">Status</th>
							<th scope="col">Mode</th>
							<th scope="col">Amount</th>
							<th scope="col">Days</th>
						</tr>
					</thead>
					<tbody>

						<%
							HttpSession httpSession = request.getSession();
						int z = 0;
						try {
							String search = request.getParameter("searchName");
							Connection con = DbConnectionProvider.getCon();
							Statement stmt = con.createStatement();
							ResultSet rs = stmt.executeQuery("select *from purchasedrecord where purchase_Date like '%" + search + "%' or purchase_Category like '%"
							+ search + "%'");
							while (rs.next()) {
								z = 1;
						%>



						<tr>
							<td class="table-info"><%=rs.getString(1)%></td>
							<td class="table-info"><%=rs.getString(2)%></td>
							<td class="table-info"><%=rs.getString(3)%></td>
							<td class="table-info"><%=rs.getString(4)%></td>
							<td class="table-info"><%=rs.getString(5)%></td>
							<td class="table-info"><%=rs.getString(6)%></td>
							<td class="table-info"><%=rs.getString(7)%></td>
							<td class="table-info"><%=rs.getString(8)%></td>
							<td class="table-info"><%=rs.getString(9)%></td>
							<td class="table-info"><%=rs.getString(10)%></td>
							<td class="table-info"><%=rs.getString(11)%></td>
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


	<%
		if (z == 0) {
		httpSession.setAttribute("message", "Searched Purchase Report does not exist...Please try Again...!!!");
		response.sendRedirect("admin.jsp");
		return;
	}
	%>
	<a href="admin.jsp" class="text-center d-block mb-2"><b>
			Admin-Home</b></a>
	<!--For Accessing CheckOut Page from directly Cart only -->
	<%@include file="components/common_modals.jsp"%>

</body>
<%@include file="components/footer.jsp"%>
</html>