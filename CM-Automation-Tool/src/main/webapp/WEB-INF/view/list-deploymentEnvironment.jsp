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

		  <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/app.css">
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
	<h2>Application Environment</h2>
	
	<!-- table to show application list -->
	<div id="container">

		<div id="content">
			
			<security:authorize access="hasRole('ADMIN')">
 
				<!--new button: Add Application ----------------------->						
				<input type="button" value="Add Environment"
					onclick="window.location.href='envAddForm'; return false;"
					class="add-button" />
			</security:authorize>
			<!--  add our html table here --------------------------------->
				<div class="col-md-12">
					<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Environment Id</th>
					<th>Environment Name</th>

					<%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasRole('ADMIN')">

						<th>Update</th>
						<th>Delete</th>

					</security:authorize>

				</tr>

				<!-- loop over and print applications -->
				<c:forEach var="tempEnvironment" items="${environments}">

					<!-- construct an "update" link with application id -->
					<c:url var="updateLink" value="/environment/envUpdateForm">
						<c:param name="environmentId" value="${tempEnvironment.environment_Id}" />
					</c:url>

					<!-- construct an "delete" link with application id -->
					<c:url var="deleteLink" value="/environment/delete">
						<c:param name="environmentId" value="${tempEnvironment.environment_Id}" />
					</c:url>

					<tr>
						<td>${tempEnvironment.environment_Id}</td>
						<td>${tempEnvironment.environmentName}</td>

						<security:authorize access="hasRole('ADMIN')">

							<td><security:authorize access="hasRole('ADMIN')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize>
							</td>
							<td> 
								<security:authorize access="hasRole('ADMIN')">
									<a href="${deleteLink}"
										onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
								</security:authorize>
							</td>

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
	</div>
	

</body>
</html>