<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>

<%@ page import="com.nagarro.hr.model.Employee"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta charset="ISO-8859-1">
<title>Dashboard</title>

<style>
.file {
	opacity: 0;
	width: 0.1px;
	height: 0.1px;
	position: absolute;
}

.file-input label {
	display: inline-block;
	background-color: indigo;
	color: white;
	padding: 0.5rem;
	font-family: sans-serif;
	border-radius: 0.3rem;
	cursor: pointer;
	margin-top: 1rem;
}

label {
	display: inline-block;
	background-color: indigo;
	color: white;
	padding: 0.5rem;
	font-family: sans-serif;
	border-radius: 0.3rem;
	cursor: pointer;
	margin-top: 1rem;
}

#customers {
	margin: auto;
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 87%;
	margin-top: 30px;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>

<body>
	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("home.jsp");
	}
	%>
	<div style="margin-left: 800px; margin-top: 20px;">
		<h2 style="text-align: right; display: inline; font-size: 22px">
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
		style="outline-style: outset; margin-left: 20px; margin-top: 10px; width: 97%;">

		<h3
			style="margin-left: 50px; margin-top: -20px; position: absolute; margin-left: 5px; background-color: white;">Employee
			Listings</h3>
		<div style="text-align: right;">
			<div class="file-input"
				style="text-align: right; display: inline-block;">
				<form method="post" action="#" enctype='multipart/form-data'
					name="myUploadForm">
					<input type="file" id="file" class="file"
						name="uploadEmployeeDetail"  onchange="this.form.submit()"
						accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />
					<label for="file">Upload Employee Detail</label>
				</form>
			</div>
			<div
				style="display: inline-block; text-align: right; margin-right: 50px;">
				<button onclick="location.href='download'"
					style="padding: 7px; background: indigo; color: white; cursor: pointer; border: none; border-radius: 3px; margin-left: 20px;">
					Download Employee Detail</button>
			</div>

		</div>
		<table id="customers">

			<tr>
				<th>EmployeeCode</th>
				<th>Name</th>
				<th>Location</th>
				<th>Email</th>
				<th>Dob</th>
				<th>Edit</th>
			</tr>
			<%
			List<Employee> employees = (List<Employee>) session.getAttribute("employees");
			if (employees.size() != 0) {

				for (Employee employee : employees) {
			%>
			<tr>
				<td><%=employee.getEmployeeCode()%></td>
				<td><%=employee.getName()%></td>
				<td><%=employee.getLocation()%></td>
				<td><%=employee.getEmail()%></td>
				<td><%=employee.getDob()%></td>
				<td>
					<form action="getEmployee" method="post">

						<input type="submit" value="Edit"> <input type="hidden"
							name="emp" value=<%=employee.getEmployeeCode()%>>
					</form>
				</td>
			</tr>
			<%
			}
			%>
			<%
			} else {
			%>
			<tr>
				<td colspan="7">No Data Found</td>
			</tr>
			<%
			}
			%>
		</table>
		<br>
	</div>
	
</body>
