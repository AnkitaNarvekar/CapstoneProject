<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">

				<div class="card">

					<%@include file="components/message.jsp"%>
					<div class="card-body px-5">

						<div class="container text-center">
							<img src="image/add-friend.png" style="max-width: 100px;"
								class="img-fluid" alt="">
						</div>
						<div class="card-header bg-secondary text-white mt-3 mb-3">
							<h1>Register Here...!!</h1>
						</div>
						<form action="RegisterCtl" method="post">
							<div class="form-group">
								<label for="name" style="color: black !important;"><b>User
										Name</b></label> <input name="user_name" type="text" class="form-control"
									id="name" aria-describedby="emailHelp"
									placeholder="Enter User Name Here..!!">
							</div>

							<div class="form-group">
								<label for="email" style="color: black !important;"><b>User
										Email-Id</b></label> <input name="user_email" type="email"
									class="form-control" id="email" aria-describedby="emailHelp"
									placeholder="Enter your Email-ID Here..!!">
							</div>

							<div class="form-group">
								<label for="password" style="color: black !important;"><b>User
										Password</b></label> <input name="user_password" type="password"
									class="form-control" id="password" aria-describedby="emailHelp"
									placeholder="Enter your Password Here..!!">
							</div>

							<div class="form-group">
								<label for="phone" style="color: black !important;"><b>User
										Phone</b></label> <input name="user_phone" type="number"
									class="form-control" id="phone" aria-describedby="emailHelp"
									placeholder="Enter your Phone Number Here..!!">
							</div>

							<div class="form-group">
								<label for="phone" style="color: black !important;"><b>User
										Address</b></label>
								<textarea name="user_address" style="height: 150px;"
									class="form-control" placeholder="Enter Your Address Here...!!"></textarea>
							</div>

							<div class="container text-center">
								<button class="btn btn-info">Register Here</button>
								<a href="login.jsp" class="text-right d-block mb-2">
									<h6 style="color: blue;">Login Page</h6>
								</a>
							</div>


						</form>

					</div>

				</div>
			</div>
		</div>
	</div>
	<!--For Accessing CheckOut Page from directly Cart only -->
	<%@include file="components/common_modals.jsp"%>

</body>
<%@include file="components/footer.jsp"%>
</html>