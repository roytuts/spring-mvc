<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC Validator Example</title>
<head>
<style>
.error {
	color: #ff0000;
	font-weight: bold;
}
</style>
</head>
<body>
	<h2>Spring MVC Validator Example</h2>
	<div>&nbsp;</div>
	<form:form action="register" method="post" modelAttribute="userForm">
                <!--<form:errors path="*" cssClass="error" />
                <div>&nbsp;</div>-->
		Name: <form:input path="name" /><form:errors path="name" cssClass="error" />
		<br />
		<br /> Email: <form:input path="email" /><form:errors path="email" cssClass="error" />
		<br />
		<br /> Address:<form:textarea path="address" rows="5" cols="30" /><form:errors path="address" cssClass="error" />
		<br />
		<input value="Add User" type="submit" />
	</form:form>
</body>
</html>
