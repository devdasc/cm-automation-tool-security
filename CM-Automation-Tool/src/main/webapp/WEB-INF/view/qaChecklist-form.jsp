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
						<!--<form:hidden path="defect_Id" />-->
						<div class="col-md-12">
							Deployment ID :
							<form:select path="deploymentPlan.deployment_Id">
							<c:forEach var="tempDeploymentPlan" items="${deploymentPlan}">
								<form:option value="${tempDeploymentPlan.deployment_Id}">${tempDeploymentPlan.deployment_Id}</form:option>
							</c:forEach>
							</form:select>
							Deployment Title :
							<form:select path="deploymentEnvironment.environmentName">
							<c:forEach var="tempEnvironment" items="${environmentList}">
								<form:option value="${environmentName.environment_Id}">${environmentName.environmentName}</form:option>
							</c:forEach>
							</form:select>
						</div>
						<br />

						<div class="col-md-12">
							Application :
							<form:select path="application.application_Id">
								<c:forEach var="tempApplication" items="${applications}">
									<form:option value="${tempApplication.application_Id}">${tempApplication.applicationName}</form:option>
								</c:forEach>
							</form:select>
							Vendor :
							<form:select path="vendor.vendor_Id">
								<c:forEach var="tempVendors" items="${vendors}">
									<form:option value="${tempVendors.vendor_Id}">${tempVendors.vendorName}</form:option>
								</c:forEach>
							</form:select>
						</div>
						<br>
						<div class="col-md-12">
							Defect Created On :
							<form:input path="defectCreationDate" placeholder="YYYY/MM/DD" />
							Fix Received On :
							<form:input path="fixRecieveDate" placeholder="YYYY/MM/DD" />
						</div>
						<br>
						<div class="col-md-12">
							Dependent Defect :
							<form:input path="dependentDefect_Id"
								placeholder="Dependent defect Id" />
							Status :
							<form:select path="status">
								<form:option value="1">Waiting For Fix</form:option>
								<form:option value="2">Fix Received</form:option>
								<form:option value="3">Deployed in SDF</form:option>
								<form:option value="4">Deployed in IST1</form:option>
								<form:option value="5">Deployed in IST2</form:option>
								<form:option value="6">Deployed in PROD</form:option>
								<form:option value="7">Deployed in Training</form:option>
								<form:option value="8">Deployed in DR</form:option>
								<form:option value="9">Closed</form:option>
							</form:select>
						</div>
						<br>
						<div class="col-md-12">
							Impact Component :
							<form:input path="impactedComponent"
								placeholder="Impacted Components" />
							Package Location :
							<form:input path="deploymentPackageLocation"
								placeholder="Paste link" />
						</div>
						<br>
						<div class="col-md-12">
							Test Case Provided ? :
							<form:select path="isTestCaseprovided">
								<form:option value="1">Provided</form:option>
								<form:option value="2">Not provided</form:option>
							</form:select>
							Instruction Provided ? :
							<form:select path="isDeploymentInstructionProvided">
								<form:option value="1">Provided</form:option>
								<form:option value="2">Not provided</form:option>
							</form:select>
						</div>
						<br>
						<div class="col-md-12">
							Review Date :
							<form:input path="reviewDate" placeholder="YYYY/MM/DD" />
						</div>
						<div class="col-md-12">
							Description : <br />
							<form:textarea class="form-control" rows="4" cols="50"
								path="description" />
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