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
<title>Defect Fix Detail</title>
<!-- <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"> -->

<!--  <link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-style.css">-->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/app.css">
	
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
  
  <script>
$(document).ready(function() {
	$(function() {
	$("#theSearchName").focus();
	});
});
</script>

</head>
<body>

<jsp:include page="/WEB-INF/view/header.jsp" />



	<!-- table to show Defect list -->
	<div class="container">
	
		<div class=" col-md-12 table table-bordered">
			<!-- <div class="left">
				<h3 style="margin-top: 10px;">Menu</h3>
			</div>-->
			<!-- button for search -->
			<div  class=" col-md-12 table table-bordered">
				<form:form action="search" method="POST" id="search">
					<input type="text" name="theSearchName" id="theSearchName"  placeholder="search"/>
					<input type="submit" value="Search" class="add-button" />
				</form:form>
			</div>
			<div class="row">
				<!--  add our html table here --------------------------------->
				<div class="col-md-12">
					<table class="table table-bordered table-striped table-hover">
						<tr>
							<th class="text-center">Defect Id</th>
							<th class="text-center">Defect Name</th>
							<th class="text-center">Application</th>
							<th class="text-center">Vendor</th>
							<%-- Only show "Action" column for CMA --%>
							<security:authorize access="hasRole('CMA')">

								<th class="text-center">Update</th>
								<th class="text-center">Delete</th>

							</security:authorize>
						</tr>
						<!-- loop over and print applications -->
						<c:forEach var="tempDefectList" items="${theDefectFixList}">

							<!-- construct an "update" link with application id -->
							<c:url var="updateLink" value="/cma/defect/defectUpdateForm">
								<c:param name="defectId" value="${tempDefectList.defect_Id}" />
							</c:url>

							<!-- construct an "delete" link with application id -->
							<c:url var="deleteLink" value="/cma/defect/delete">
								<c:param name="defectId" value="${tempDefectList.defect_Id}" />
							</c:url>

							<tr>
								<td class="text-center">${tempDefectList.defect_Id}</td>
								<td class="text-center">${tempDefectList.title}</td>
								<td class="text-center">${tempDefectList.application.applicationName}</td>
								<td class="text-center">${tempDefectList.vendor.vendorName}</td>
								
								<security:authorize access="hasRole('CMA')">

									<td><security:authorize access="hasRole('CMA')">
											<!-- display the update link -->
											<a href="${updateLink}">Update</a>
										</security:authorize> 
										
										</td>
										<td>
										<security:authorize access="hasRole('CMA')">
											<a href="${deleteLink}"
												onclick="if (!(confirm('Are you sure you want to delete?'))) return false">Delete</a>
										</security:authorize></td>

								</security:authorize>

							</tr>

						</c:forEach>

					</table>
					</div>
						<!-- col-md-12 -->
					</div>
					<!-- col-md-12 table table-bordered -->

				</div>
				<!-- row -->

			</div>
			<!-- container -->
			<p></p><p></p>
			<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" class="add-button" />
			</form:form>

			<!-- ++++++++++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>