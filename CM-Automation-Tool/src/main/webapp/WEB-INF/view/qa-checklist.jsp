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
<title>QA CheckList</title>
</head>
<body>
<jsp:include page="/WEB-INF/view/header.jsp" />

	<h2>QA Checklist</h2>
	<!-- table to show application list -->
	<div id="container">
		<div id="content">
			<!--  add our html table here --------------------------------->
				<div class="col-md-12">
					<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Deployment Name</th>
					<th>Environment Name</th>
					<th>Application Name</th>
					<th>Status</th>

					<%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasRole('QA')">

						<th>Update</th>
						<th>Delete</th>

					</security:authorize>

				</tr>

				<!-- loop over and print applications -->
				<c:forEach var="tempQAChecklist" items="${qaCheckList}">

					<!-- construct an "update" link with application id -->
					<c:url var="updateLink" value="/qa/checkList/qaCheckListUpdateForm">
						<c:param name="qaChecklistId" value="${tempQAChecklist.qachecklist_id}" />
						
					</c:url>

					<!-- construct an "delete" link with application id -->
					<c:url var="deleteLink" value="/qa/checkList/delete">						
						<c:param name="qaChecklistId" value="${tempQAChecklist.qachecklist_id}" />
						
					</c:url>

					<tr>
						<td>${tempQAChecklist.deploymentPlan.title}</td>
						<td>${tempQAChecklist.deploymentEnvironment.environmentName}</td>
						<td>${tempQAChecklist.deploymentPlan.application.applicationName}</td>
						<td>${tempQAChecklist.testStatus}</td>

						<security:authorize access="hasRole('QA')">

							<td><security:authorize access="hasRole('QA')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize>
							</td>
							<td> 
								<security:authorize access="hasRole('QA')">
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
	

</body>
</html>