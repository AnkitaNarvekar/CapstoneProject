
<%
	User user = (User) session.getAttribute("current-user");
if (user == null) {

	session.setAttribute("message", "You are not logged in !! Login first to access Checkout page");
	response.sendRedirect("login.jsp");
	return;

}
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Checkout Page</title>
<%@include file="components/common_css_js.jsp"%>

</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container">
		<%@include file="components/message.jsp"%>
		<div class="row mt-5">

			<div class="col-md-6">
				<!--card-->
				<div class="card">
					<div class="card-body">

						<h3 class="text-center mb-5" style="color: blue;">Your
							Selected Items</h3>

						<div class="cart-body"></div>
					</div>
				</div>

			</div>
			<div class="col-md-6">
				<!--form details-->
				<!--card-->
				<div class="card">
					<div class="card-body">

						<h3 class="text-center mb-5 " style="color: blue;">Your
							Details For Order</h3>

						<form action="CheckoutOrderedCtl" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1"><b>Email Address</b></label> <input
									name="userEmail" value="<%=user.getUserEmail()%>" type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email">
								<small id="emailHelp" class="form-text text-muted">We'll
									never share your email with anyone else.</small>
							</div>
							<div class="form-group">
								<label for="name"><b>Your Name</b></label> <input
									name="userName" value="<%=user.getUserName()%>" type="text"
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter name">
							</div>


							<div class="form-group">
								<label for="name"><b>Your Contact</b></label> <input
									name="userPhone" value="<%=user.getUserPhone()%>" type="text"
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter contact number">
							</div>

							<div class="form-group">
								<label for="name"><b>Purchase Date</b></label> <input
									name="purchaseDate" type="date" class="form-control" id="name"
									aria-describedby="emailHelp" placeholder="Enter purchase Date"
									required>
							</div>


							<div class="form-group">
								<label for="Category"><b>Select Food Category for
										Delivery...!!</b></label><br> <select name="purchaseCategory"
									required>
									<option selected>Default Food item Category is
										Selected</option>
									<option value="Biryani">Biryani</option>
									<option value="Chicken">Chicken</option>
									<option value="Pizza">Pizza</option>
									<option value="Bowl">Bowl</option>
									<option value="Paratha">Paratha</option>
									<option value="Home Style">Home Style</option>
									<option value="Desi Chai">Desi Chai</option>
									<option value="Chinese">Chinese</option>
									<option value="Indian Roti">Indian Roti</option>
									<option value="Rice">Rice</option>
									<option value="Soup">Soup</option>
								</select>
							</div>


							<div class="form-group">
								<label for="paymentMode"><b>Select Payment Mode</b></label><br>
								<select name="paymentMode" required>
									<option selected>Default Payment Mode is Cash on
										Delivery</option>
									<option value="Cash On Delivery">Cash On Delivery</option>
									<option value="NetBanking">NetBanking</option>
									<option value="Credit Card">Credit Card</option>
									<option value="UPI ID">UPI ID</option>
								</select>
							</div>


							<div class="form-group">
								<label for="name"><b>Purchase Total Amount</b></label> <input
									name="totalAmount" value="totalAmount" type="number"
									class="form-control" id="name" aria-describedby="emailHelp"
									placeholder="Enter Total Amount of Purchase" required>
							</div>


							<div class="form-group">
								<label for="exampleFormControlTextarea1"><b>Your
										Shipping Address</b></label>
								<textarea name="shippingAddress" value="shippingAddress"
									class="form-control" id="exampleFormControlTextarea1"
									placeholder="Enter your address" rows="3" required></textarea>
							</div>

							<div class="container text-center">


								<button class="btn btn-info">Order Now</button>
								<!-- <button class="btn btn-outline-primary">Continue Shopping With US</button> -->
								<div class="container text-center mt-3">
									<a href="foodboxWelcome.jsp" class="text-center d-block mb-2"><h5
											style="color: blue;">Explore Our Food..!!!</h5> </a>
								</div>
							</div>

						</form>

					</div>
				</div>
			</div>
		</div>

	</div>

	<%@include file="components/common_modals.jsp"%>
</body>
<%@include file="components/footer.jsp"%>
</html>
