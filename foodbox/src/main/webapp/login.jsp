<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<%@include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>
	<div class="container">

		<div class="row">
			<div class="col-md-6 offset-md-4">

				<div class="card mt-3">
					<div class="card-header bg-secondary text-white">
						<h1>Login Here :</h1>
					</div>

					<div class="card-body">
						<%@ include file="components/message.jsp"%>

						<form action="LoginCtl" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									name="email" type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									placeholder="Enter email"> <small id="emailHelp"
									class="form-text text-muted">We'll never share your
									email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									name="password" type="password" class="form-control"
									id="exampleInputPassword1" placeholder="Password">
							</div>

							<a href="register.jsp" class="text-center d-block mb-2">New
								User..!! Please Click Here</a>

							<div class="container text-center">
								<button type="submit" class="btn btn-primary bg-info border-0">Submit</button>
								<button type="reset" class="btn btn-primary bg-info border-0">Reset</button>
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