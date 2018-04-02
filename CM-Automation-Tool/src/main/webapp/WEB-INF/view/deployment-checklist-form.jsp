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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	<h2>Deployment CheckList Form</h2>

	<!-- form---------------------------------------------------->
	<div class="container">
		<div class="row">
			<div class=" col-md-12  table table-bordered">

				<div class="centre">
					<form:form method="POST" action="saveDeploymentCheckList"
						modelAttribute="theDeploymentCheckList">
					<!-- associate this data with deploymentChecklist_Id -->
						<form:hidden path="deploymentChecklist_Id" />
						
						<div class="col-md-12">
							Deployment Name:
							<form:select path="deploymentPlan.deployment_Id">
								<c:forEach var="tempDeploymentPlan" items="${deploymentPlan}">
									<form:option value="${tempDeploymentPlan.deployment_Id}">${tempDeploymentPlan.title}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<br />
						<div class="col-md-12">
							Environment :
							<form:select path="deploymentEnvironment.environment_Id">
								<c:forEach var="tempEnvironment"
									items="${deploymentEnvironmentList}">
									<form:option value="${tempEnvironment.environment_Id}">${tempEnvironment.environmentName}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<br />
						<div class="col-md-12">
							Actual Deployment Date :
							<form:input type="date" path="actualDeploymentDate"
								required="true" />
						</div>
						<br>
						<div class="col-md-12">
							Package Deployed ? :
							<form:select path="isPackageDeployed">								
								<form:option value="y">Yes</form:option>
								<form:option value="n">No</form:option>
							</form:select>
						</div>
						<br>
						<div class="col-md-12">
							Deployed Package Info :
							<form:textarea class="form-control" rows="4" cols="30"
								path="deployedPackageInfo" required="true" />
						</div>
						<br>
						<div class="col-md-12">
							Parameter Deployed ? :
							<form:select path="isParameterDeployed">								
								<form:option value="y">Yes</form:option>
								<form:option value="n">No</form:option>
							</form:select>
						</div>
						<br>
						<div class="col-md-12">
							Deployed Parameter Information :
							<form:textarea class="form-control" rows="4" cols="30"
								path="deployedParameterInfo" required="true" />
						</div>
						<br>
						<div class="col-md-12">
							Database Executed ? :
							<form:select path="isDBScriptExecuted">								
								<form:option value="y">Yes</form:option>
								<form:option value="n">No</form:option>
							</form:select>
						</div>
						<br>
						<div class="col-md-12">
							Database Script Information :
							<form:textarea class="form-control" rows="4" cols="30"
								path="dBScriptInfo" required="true" />
						</div>
						<br>
						<div class="col-md-12">
							Additional Information :
							<form:textarea class="form-control" rows="4" cols="30"
								path="otherDeploymentInfo" required="true" />
						</div>
						<br>
						<div class="col-md-12">
							Deployed by :
							<form:input type="text" path="deployedBy" required="true" />
						</div>
						<br>
						<br>
						<div class="col-md-offset-3">
							<input type="submit" value="Save" />
						</div>
					</form:form>
				</div>
				<!-- centre -->

			</div>
			<!-- row -->
		</div>
		</div>
		<!-- container -->
		<!--  end of form ----------------------------------------------------->
		<p></p>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input type="submit" value="Logout" class="add-button" />
		</form:form>
</body>
</html>