<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.nagarro.hr.model.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
</head>
<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("home.jsp");
	}
	%>
	<div style="margin-left: 800px; margin-top: 20px;">
		<h2 style="text-align: right; display: inline">
			Welcome
			<%=session.getAttribute("username")%>!
		</h2>
		<form style="display: inline; text-align: right; margin-left: 30px;"
			action="Logout" method="post">
			<button class="closeBtn"
				style="border-radius: 50%; background-color: red; cursor: pointer;">
				<i class="fa fa-close"></i>
			</button>
		</form>
	</div>
	<div
		style="outline-style: outset; margin-left: 20px; padding-bottom: 5px; width: 90%">

		<h3 style="text-align: center; margin-top: 10px;">Edit Employee
			Detail</h3>
		<%
		Employee employee = (Employee) session.getAttribute("employee");
		%>
		<form action="edit" style="margin-top: 50px; margin-left: 400px;">
			<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<label>Employee Code:</label>

					</div>
					<div class="col-sm-9">
						<input type="text" name="employeeCode"
							value="<%=employee.getEmployeeCode()%>">
					</div>

				</div>
			</div>

			<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<label>Employee Name:</label>

					</div>
					<div class="col-sm-9">
						<input type="text" name="employeeName"
							value="<%=employee.getName()%>">
					</div>

				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<label>Location:</label>

					</div>
					<div class="col-sm-9">
						<input name="location" type="text"
							value="<%=employee.getLocation()%>">
					</div>

				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<label>Email:</label>

					</div>
					<div class="col-sm-9">
						<input name="email" type="email" value="<%=employee.getEmail()%>">
					</div>

				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-sm-3">
						<label>Dob:</label>

					</div>
					<div class="col-sm-9">
						<input name="dob" type="text" value="<%=employee.getDob()%>">
					</div>

				</div>
			</div>
			<input style="margin-left: 150px; margin-top: 20px;" type="submit"
				value="save"> <input style="margin-left: 50px;"
				type="button" value="cancel"
				onclick="window.location='dashboard.jsp'">
		</form>
	</div>
</body>
</html>