<%@page import="com.foodbox.helper.DbConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search User</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="row">
		<div class="col-md-6 offset-md-4">

			<div class="card mt-3">
				<%@include file="components/message.jsp"%>


				<table class="table table-bordered">
					<thead>
						<tr class="table-info">
							<th scope="col">Id</th>
							<th scope="col">Address</th>
							<th scope="col">Email</th>
							<th scope="col">Name</th>
							<th scope="col">Password</th>
							<th scope="col">Phone</th>
							<th scope="col">UserType</th>
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
							ResultSet rs = stmt.executeQuery("select *from user where user_name like '%" + search + "%' or user_email like '%"
							+ search + "%' or user_phone like '%" + search + "%' ");
							while (rs.next()) {
								z = 1;
						%>



						<tr>
							<th class="table-success" scope="row"><%=rs.getString(1)%></th>
							<td class="table-success"><%=rs.getString(2)%></td>
							<td class="table-success"><%=rs.getString(3)%></td>
							<td class="table-success"><%=rs.getString(4)%></td>
							<td class="table-success"><%=rs.getString(5)%></td>
							<td class="table-success"><%=rs.getString(6)%></td>
							<td class="table-success"><%=rs.getString(8)%></td>
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
		httpSession.setAttribute("message", "Searched User Data does not exist...Please try Again...!!!");
		response.sendRedirect("admin.jsp");
		return;
	}
	%>
	<a href="admin.jsp" class="text-center d-block mb-2"><b> Admin
			Panel</b></a>
	<!--For Accessing CheckOut Page from directly Cart only -->
	<%@include file="components/common_modals.jsp"%>

</body>
<%@include file="components/footer.jsp"%>
</html>