<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Add Environment</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-style.css">
		  
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
	<div id="wrapper">
		<div id="header">
			<h2>Environment</h2>
		</div>
	</div>

	<div id="container">
		<h3>Deployment Environments</h3>
	
		<form:form action="saveEnvironment" modelAttribute="environments" method="POST">

			<!-- need to associate this data with application id -->
			<form:hidden path="environment_Id" />
					
			<table>
				<tbody>
					<!--<tr>
						<td><label>Environment ID:</label></td>
						<td><form:input path="environment_Id" readonly="true"/></td>
					</tr>--> 
					<tr>
						<td><label>Environment Name:</label></td>
						<td><form:input path="environmentName" required="true"/></td>
						
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description"/></td>
						
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
			<a href="${pageContext.request.contextPath}/environment/list">Back to List</a>
		</p>
	
	</div>

</body>
</html>