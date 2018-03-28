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
<title>Deployment List</title>

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
	<h2>Deployment List</h2>

	<div class="col-md-12">
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Deployment Id</th>
				<th>Deployment Title</th>
				<th>Application Name</th>
				<th>Defects</th>

				<%-- Only show "Action" column for managers or admin --%>
				<security:authorize access="hasRole('CMA')">
					<th>Update</th>
					<th>Delete</th>
				</security:authorize>
			</tr>
			<!-- loop over and print applications -->
			<c:forEach var="tempDeploymentPlan" items="${theDeploymentPlanList}">

				<!-- construct an "update" link with application id -->
				<c:url var="updateLink"
					value="/cma/deployment/deploymentPlanUpdateForm">
					<c:param name="deploymentId"
						value="${tempDeploymentPlan.deployment_Id}" />
				</c:url>

				<!-- construct an "delete" link with application id -->
				<c:url var="deleteLink" value="/cma/deployment/delete">
					<c:param name="deploymentId"
						value="${tempDeploymentPlan.deployment_Id}" />
				</c:url>

				<tr>
					<td>${tempDeploymentPlan.deployment_Id}</td>
					<td>${tempDeploymentPlan.title}</td>
					<td>${tempDeploymentPlan.application.applicationName}</td>
					<td>
					<c:forEach var="tempDefects" items="${tempDeploymentPlan.listDefectFixDetail}">
						<a>${tempDefects.title}</a>
					</c:forEach>
					</td>

					<security:authorize access="hasRole('CMA')">

						<td><security:authorize access="hasRole('CMA')">
								<!-- display the update link -->
								<a href="${updateLink}">Update</a>
							</security:authorize></td>
						<td><security:authorize access="hasRole('CMA')">
								<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
							</security:authorize></td>

					</security:authorize>

				</tr>

			</c:forEach>
		</table>
	</div>

</body>
</html>