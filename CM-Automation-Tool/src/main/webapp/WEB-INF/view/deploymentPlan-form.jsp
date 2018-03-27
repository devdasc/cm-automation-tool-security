<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
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
					<form method="POST" action="saveDeploymentPlan" modelAttribute="deploymentPlanDetail">					
						<hidden path="deployment_Id" />
						
						<div class="col-md-12">		
							Deployment Title :
							<input path="title" placeholder="Deployment Title" />
						</div>
						<br />
						<div class="col-md-12">
							Application :
							<select path="application.application_Id">
								<option value="1">APP1</option>
								<option value="2">APP2</option>
								<option value="3">APP3</option>
							</select>
						</div>
						<br />
						<div class="col-md-12">
							Plan Date :
							<input path="planDate" placeholder="yyyy/mm/dd" />
						</div>
						<br />
						<div class="col-md-12">
							Dev Deployment Date :
							<input path="dev_DeploymentDate" placeholder="yyyy/mm/dd" />
						</div>
						<br />
						<div class="col-md-12">
							SDF Deployment Date :
							<input path="sdf_DeploymentDate" placeholder="yyyy/mm/dd" />
						</div>
						<br />
						<div class="col-md-12">
							IST1 Deployment Date :
							<input path="ist1_DeploymentDate" placeholder="yyyy/mm/dd" />
						</div>
						<br />
						<div class="col-md-12">
							IST2 Deployment Date :
							<input path="ist2_DeploymentDate" placeholder="yyyy/mm/dd" />
						</div>
						<br />
						<div class="col-md-12">
							PROD Deployment Date :
							<input path="prod_DeploymentDate" placeholder="yyyy/mm/dd" />
						</div>
						<br />
						<div class="col-md-12">
							Comment :
							<form:textarea class="form-control" rows="4" cols="50"
								path="comment" />
						</div>
						<!-- <div class="col-md-12">
							Defect to Deploy :
							<select path="defect_Id"   id="defect_Id">
								<option value="1">Defect 1</option>
								<option value="2">Defect 2</option>
							</select>
						</div> -->
						<br />
						<div class="col-md-offset-3">
							<input type="submit" value="Save" />

						</div>
				</form>
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