<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="Jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color: red; text-align: center">Student Registration
	Form Page</h1>
<spring:form  method="POST" commandName="stdCmd">
	<table border="2" cellpadding="5" cellspacing="5" align="center">
		<tr>
			<th>Student Number::</th>
			<td><spring:input path="sno" readonly="true" disabled="true" />  <spring:errors path="sno" style="color:red" /></td>
		</tr>
		<tr>
			<th>Student Name::</th>
			<td><spring:input path="sname" />  <spring:errors path="sname" style="color:red" /></td>
		</tr>
		<tr>
			<th>Student Address::</th>
			<td><spring:input path="saddrs" />  <spring:errors path="saddrs" style="color:red"/> </td>
		</tr>
		<tr>
			<th>Course::</th>
			<td><spring:input path="course" />  <spring:errors path="course" style="color:red" /> </td>
		</tr>
		<tr>
			<th>Fee::</th>
			<td><spring:input path="fee" />  <spring:errors path="fee" style="color:red" /> </td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Update"></td>
		</tr>
	</table>
</spring:form>

<br><br><br>
<a href="index.jsp">Home</a>