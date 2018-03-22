<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CM Automation Home page</title>
</head>
<body>
	<h2>CM Automation Home page</h2>
	<hr>
	<h3>Welcome to CM Automation Web App</h3>
	<hr>
	<!-- Display user and roles -->
	<p>
		User :
		<security:authentication property="principal.username" /><br> 
		
		<security:authentication property="principal.authorities" />
	</p>
	<hr>
	 
	<security:authorize access="hasAnyRole('CMA','QA','TSA')">
		<!-- Add link to point to Leaders..this is for the managers	 -->
		<p>
			<a href="${pageContext.request.contextPath}/cma/defect/list">Defect Fix Detail</a>
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add link to the Admins..this is for the Admin people -->
		<p>
			<a href="${pageContext.request.contextPath}/admin/app/list">Applications</a>
		</p>
		<hr>
	</security:authorize>

	<!-- Adding a logout form -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>