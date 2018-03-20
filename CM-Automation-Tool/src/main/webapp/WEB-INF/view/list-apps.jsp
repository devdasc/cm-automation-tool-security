<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CM Automation systems home page</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-style.css">
</head>
<body>
	<h2>CM Automation systems home page</h2>
	<hr>
	<p>Hi This is the Systems home page</p>
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to home page</a>
	<!-- table to show application list -->
	<div id="container">

		<div id="content">
			<p>
				User:
				<security:authentication property="principal.username" />
				, Role(s):
				<security:authentication property="principal.authorities" />
			</p>
			<security:authorize access="hasRole('ADMIN')">

				<!--new button: Add Application ----------------------->						
				<input type="button" value="Add Application"
					onclick="window.location.href='appAddForm'; return false;"
					class="add-button" />
			</security:authorize>
			<!--  add our html table here --------------------------------->
			<table>
				<tr>
					<th>Application Id</th>
					<th>Application Name</th>

					<%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasRole('ADMIN')">

						<th>Action</th>

					</security:authorize>

				</tr>

				<!-- loop over and print applications -->
				<c:forEach var="tempApplication" items="${applications}">

					<!-- construct an "update" link with application id -->
					<c:url var="updateLink" value="/admin/app/appUpdateForm">
						<c:param name="applicationId" value="${tempApplication.appId}" />
					</c:url>

					<!-- construct an "delete" link with application id -->
					<c:url var="deleteLink" value="/admin/app/delete">
						<c:param name="applicationId" value="${tempApplication.appId}" />
					</c:url>

					<tr>
						<td>${tempApplication.appId}</td>
						<td>${tempApplication.appName}</td>

						<security:authorize access="hasRole('ADMIN')">

							<td><security:authorize access="hasRole('ADMIN')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize> <security:authorize access="hasRole('ADMIN')">
									<a href="${deleteLink}"
										onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
								</security:authorize></td>

						</security:authorize>

					</tr>

				</c:forEach>

			</table>

		</div><!-- content -->

	</div><!-- container -->
	<p></p>
		
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" class="add-button" />
	
	</form:form>

</body>
</html>