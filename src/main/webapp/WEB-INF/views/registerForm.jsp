<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "sf" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
	<h1>Register</h1>
	<sf:form method = "POST" commandName = "spitter">
		<sf:errors path = "*" element = "div" cssClass = "error"/><br/>
		<sf:label path="firstName" cssErrorClass ="error"> First Name</sf:label>
		<sf:input path= "firstName" cssErrorClass ="error"/><br/>
		<sf:label path="lastName" cssErrorClass ="error"> Last Name</sf:label>
		Last Name: <sf:input path= "lastName" cssErrorClass ="error"/><br/>
		<sf:label path="userName" cssErrorClass ="error"> UserName</sf:label>
		UserName: <sf:input path= "userName" cssErrorClass ="error"/><br/>
		<sf:label path="password" cssErrorClass ="error"> Password</sf:label>
		Password: <sf:password path= "password" cssErrorClass ="error"/><br/>
		<input type = "submit" value = "Register"/>
	</sf:form>
</body>
</html>