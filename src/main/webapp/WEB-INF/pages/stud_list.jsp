<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color: red; text-align: center">Student List Details</h1>
<student:choose>
	<student:when test="${!empty studentList}">
		<table border="2" cellpadding="5" cellspacing="5" align="center">
			<tr>
				<th>SNO</th>
				<th>SNAME</th>
				<th>SADDRS</th>
				<th>COURSE</th>
				<th>FEE</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
			<student:forEach var="dto" items="${studentList}">

				<tr>
					<td>${dto.sno}</td>
					<td>${dto.sname}</td>
					<td>${dto.saddrs}</td>
					<td>${dto.course}</td>
					<td>${dto.fee}</td>
					<td><a href="edit.htm?sno=${dto.sno}">EDIT</a></td>
					<td><a href="delete.htm?sno=${dto.sno}">DELETE</a></td>
				</tr>
			</student:forEach>
			<tr><td colspan="7" align="center"><a href="form.htm">Insert Record</a></td></tr>
		</table>
	</student:when>
	<student:otherwise>
       <h1 style="color: red;text-align: center">Record Not Found</h1>
	</student:otherwise>
</student:choose>
<br><br><br>
<student:if test="${message ne null}"><span style="color:green;text-align:center">${message}</span></student:if>
<br><br><br>
<a href="index.jsp">Home</a>