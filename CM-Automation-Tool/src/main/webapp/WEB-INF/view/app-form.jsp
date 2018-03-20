<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Applicationr</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Application</h2>
		</div>
	</div>

	<div id="container">
		<h3>Application</h3>
	
		<form:form action="saveApplication" modelAttribute="application" method="POST">

			<!-- need to associate this data with application id -->
			<form:hidden path="appId" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Application ID:</label></td>
						<td><form:input path="appId" /></td>
					</tr>
					<tr>
						<td><label>Application Name:</label></td>
						<td><form:input path="appName" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/admin/app/list">Back to List</a>
		</p>
	
	</div>

</body>
</html>