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
	<h2>QA CheckList Form</h2>

	<!-- form---------------------------------------------------->
	<div class="container">
		<div class="row">
			<div class=" col-md-12  table table-bordered">

				<div class="centre">
					<form:form method="POST" action="saveQACheckList"
						modelAttribute="theQACheckListDetail">
						<!-- associate this data with Defect id -->
					<form:hidden path="qachecklist_id" />
						
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
							<c:forEach var="tempEnvironment" items="${deploymentEnvironmentList}">
								<form:option value="${tempEnvironment.environment_Id}">${tempEnvironment.environmentName}</form:option>
							</c:forEach>
							</form:select>
						</div>
						<br/>
						<div class="col-md-12">
							Test Date :
							<form:input type="date" path="testDate"  required="true"/>
						</div>
						<br>
						<div class="col-md-12">
							Status :
							<form:select path="testStatus">
								<form:option value="1">Pass</form:option>
								<form:option value="2">Fail</form:option>
							</form:select>
						</div>
						<br>					
						<div class="col-md-12">
							Comment : <br />
							<form:textarea class="form-control" rows="4" cols="30"
								path="comment" required="true"/>
						</div>
						<br>
						<div class="col-md-12">
							Tested by:
							<form:input path="testedBy" type="text" />
						</div>
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
		<!-- container -->
		<!--  end of form ----------------------------------------------------->
		<p></p>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input type="submit" value="Logout" class="add-button" />
		</form:form>
</body>
</html>