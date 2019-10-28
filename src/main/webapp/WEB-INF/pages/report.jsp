<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script>
function confirmDelete(){
	return confirm("Are you sure you want to delete?");
}
</script>

<title>Insert title here</title>
</head>

<body>

	<h3 style="text-align: center; color: green;">
	<a align="center" href="index.jsp">+Add student</a>
	<table border="1" align="center">
		<tr>
			<th>Sr.No</th>
			<th>Name</th>
			<th>Address</th>
			<th>Qualification</th>
			<th>Action</th>
		</tr>

		<c:forEach var="student" items="${allStudent}" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${student.name}</td>
				<td>${student.address}</td>
				<td>${student.qlfy}</td>
				<td><a href="edit?id=${student.id}">Edit</a>&nbsp;&nbsp; <a
					href="delete?id=${student.id}" onclick="return confirmDelete()">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${cp>1}">
		<a href="allstudent1?pn=${cp-1}">Previous</a>
	</c:if>

	

		<c:forEach var="i" begin="1" end="${tp}">
		<c:choose>
			<c:when test="${cp==i}">
				<c:out value="${i}"></c:out>
			</c:when>

			<c:otherwise>
				<a href="allstudent1?pn=${i}"><c:out value="${i}"></c:out></a>
			</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<c:if test="${cp<tp}">
			<a href="allstudent1?pn=${cp+1}">Next</a>
		</c:if>
		
		</h1>
</body>
</html>