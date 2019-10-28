<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="update?id=${stud.id}" method="POST" modelAttribute="stud">
		<table border="1" align="center">
			<tr>
				<td>Enter student name</td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td>Enter student address</td>
				<td><form:input path="address" /></td>
			</tr>

			<tr>
				<td>Enter student qualification</td>
				<td><form:input path="qlfy" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>