
<%
	String message = (String) session.getAttribute("message");
if (message != null) {

	//Printing Message according to need 

	//out.println(message);
%>

<div class="alert alert-success alert-dismissible fade show"
	role="alert">
	<strong><%=message%></strong>
	<button type="button" class="close" data-dismiss="alert"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
</div>


<%
	//After Printing Message according to need remove session value so that we can reuse session again

session.removeAttribute("message");
}
%>