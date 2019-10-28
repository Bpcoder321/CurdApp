<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
.error {
	color: #FF0000
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="registrationForm"]').validate({
			rules : {
				name : 'required',
				address : 'required',
				qlfy:'required'
			},
			messages : {
				name : 'Please enter name',
				address : 'please enter address',
				qlfy : 'Please enter qualification'
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>


<title>Insert title here</title>
</head>
<body>
	<form:form action="add" method="POST" modelAttribute="stud" 
		id="registrationForm">
		
	<h3 style="text-align: center;"><a href="allstudent1?pn=1">View all student</a></h1>
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
				<td><input type="reset" value="Reset"></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
		
		
	</form:form>
</body>
</html>