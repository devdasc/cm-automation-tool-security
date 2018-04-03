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
<title>Deployment Plan</title>
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
	<h2>Deployment Plan Page</h2>


	<!-- Add a logout button -->

	<div class="container">
		<div class="row">
			<div class=" col-md-12  table table-bordered">
				<div class="centre">
					<form:form method="POST" action="saveDeploymentPlan"
						modelAttribute="deploymentPlanDetail">
						<form:hidden path="deployment_Id" />

						<div class="col-md-12">
							Deployment Title :
							<form:input path="title" placeholder="Deployment Title" required="true"/>
						</div>
						<br />
						<div class="col-md-12">
							Application :
							<form:select path="application.application_Id">
								<c:forEach var="tempApplication" items="${applications}">
									<form:option value="${tempApplication.application_Id}">${tempApplication.applicationName}
                					</form:option>
								</c:forEach>
							</form:select>
						</div>
						<br />
						<div class="col-md-12">
							Defects to Deploy :
							<form:select path="defects" required="true">
			            		<form:options items="${listDefectFixDetail}" itemValue="defect_Id" itemLabel="title"/>
						</form:select>						
						</div>
						<br />
						<div class="col-md-12">
							Plan Date :
							<form:input type="date" path="planDate" placeholder="yyyy-mm-dd" required="true"/>
						</div>
						<br />
						<div class="col-md-12">
							Dev Deployment Date :
							<form:input  type="date" path="dev_DeploymentDate" placeholder="yyyy-mm-dd" required="true"/>
						</div>
						<br />
						<div class="col-md-12">
							SDF Deployment Date :
							<form:input  type="date" path="sdf_DeploymentDate" placeholder="yyyy-mm-dd" required="true"/>
						</div>
						<br />
						<div class="col-md-12">
							IST1 Deployment Date :
							<form:input  type="date" path="ist1_DeploymentDate" placeholder="yyyy-mm-dd" required="true"/>
						</div>
						<br />
						<div class="col-md-12">
							IST2 Deployment Date :
							<form:input  type="date" path="ist2_DeploymentDate" placeholder="yyyy-mm-dd" required="true"/>
						</div>
						<br />
						<div class="col-md-12">
							PROD Deployment Date :
							<form:input  type="date" path="prod_DeploymentDate" placeholder="yyyy-mm-dd" required="true"/>
						</div>
						<br />
						<div class="col-md-12">
							Comment :
							<form:textarea path="comment" class="form-control" rows="4"
								cols="50" required="true"/>
						</div>

						<br />
						<div class="col-md-offset-3">
							<input type="submit" value="Save" />

						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div>
			<form:form action="${pageContext.request.contextPath}/logout"
				method="POST">
				<input type="submit" value="Logout" class="add-button" />

			</form:form>
		</div>
	</div>

</body>
</html>