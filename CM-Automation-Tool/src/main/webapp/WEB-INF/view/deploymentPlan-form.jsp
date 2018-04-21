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
<title>${title} </title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
	
<script type="text/javascript"
	src="<c:url value="/resources/jquery/1.6/jquery-1.6.1.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/jquery-ui/jquery-ui-1.8.10.custom.min.js" />"></script>	
<script type="text/javascript"
	src="<c:url value="https://code.jquery.com/jquery-3.3.1.min.js" />"></script>


<style>
.error {
	color: red
}
</style>
</head>

<body>
<jsp:include page="/WEB-INF/view/header.jsp" />
<div class="content-page">
	<div id="wrapper">
		<div id="header">
			<h2>Defect Fix Detail</h2>
		</div>
	</div>

	<!-- form---------------------------------------------------->
	<div class="container">
	<form:form method="POST" action="saveDeploymentPlan"
						modelAttribute="deploymentPlanDetail">
		<form:hidden path="deployment_Id" />
		<table>
				<tbody>					 
					<tr>
						<td>
							<label>	Deployment Title :</label>
						</td>
						<td>
							<form:input path="title"  class="form-control" placeholder="Deployment Title"
								required="true" />
							<form:errors path="title" cssClass="error" />
						</td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>
							<label>Application :</label>
						</td>
						<td colspan="3">
							<form:select  class="form-control" path="application.application_Id" id="applications">
								<c:forEach var="tempApplication" items="${applications}">
									<form:option value="${tempApplication.application_Id}">${tempApplication.applicationName}
                					</form:option>
								</c:forEach>
							</form:select>						
						</td>
					</tr>
					<tr>
						<td>
							<label>Defects to Deploy :</label>
						</td>
						<td colspan="3">
							<form:select  class="form-control" path="defects" required="true">
								<form:options items="${listDefectFixDetail}"
									itemValue="defect_Id" itemLabel="title" />
							</form:select>
						</td>
					</tr>
					<tr>
						<td>
							<label>Plan Date :</label>
						</td>
						<td>
							<form:input type="date"   class="form-control" path="planDate" placeholder="yyyy-mm-dd"
								required="true" />
							<form:errors path="planDate" cssClass="error" />
						</td>
						<td>
							<label>Dev Deployment Date :</label>
						</td>
						<td>
							<form:input type="date"  class="form-control" path="dev_DeploymentDate"
								placeholder="yyyy-mm-dd" required="true" />
							<form:errors path="dev_DeploymentDate" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td>
							<label>SDF Deployment Date :</label>
						</td>
						<td>
							<form:input type="date"  class="form-control" path="sdf_DeploymentDate"
								placeholder="yyyy-mm-dd" required="true" />
							<form:errors path="sdf_DeploymentDate" cssClass="error" />
						</td>
						<td>
							<label>IST1 Deployment Date :</label>
						</td>
						<td>
							<form:input type="date"  class="form-control" path="ist1_DeploymentDate"
								placeholder="yyyy-mm-dd" required="true" />
							<form:errors path="ist1_DeploymentDate" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td>
							<label>IST2 Deployment Date :</label>
						</td>
						<td>
							<form:input type="date"  class="form-control" path="ist2_DeploymentDate"
								placeholder="yyyy-mm-dd" required="true" />
							<form:errors path="ist2_DeploymentDate" cssClass="error" />
						</td>
						<td>
							<label>PROD Deployment Date :</label>
						</td>
						<td>
							<form:input type="date"  class="form-control" path="prod_DeploymentDate"
								placeholder="yyyy-mm-dd" required="true" />
							<form:errors path="prod_DeploymentDate" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td>
							<label>Comment :</label>
						</td>
						<td colspan="3">
							<form:textarea path="comment" class="form-control" rows="3"
								cols="50" required="true" />
							<form:errors path="comment" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Save" />
						</td>						
					</tr>
				</tbody>
			</table>
		</form:form>				
	</div>		
</div>
<div>
<jsp:include page="/WEB-INF/view/footer.jsp" />
</div>