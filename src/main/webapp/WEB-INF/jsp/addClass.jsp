<%--
  Created by IntelliJ IDEA.
  User: Thodoris
  Date: 06-Aug-18
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="newClassTitle"/> </title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Le styles -->
	<link href="assets/css/bootstrap.css" rel="stylesheet">
	<style>
		body { padding-top: 60px; /* 60px to make the container go all the way
	  to the bottom of the topbar */ }
	</style>
	<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
	</script>
	<![endif]-->
	<!-- Le fav and touch icons -->
	<link rel="shortcut icon" href="assets/ico/favicon.ico">
	<link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
	<link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

	<style>
		.error {
			color: #ff0000;
		}

		.errorblock {
			color: #000;
			background-color: #ffEEEE;
			border: 3px solid #ff0000;
			padding: 8px;
			margin: 16px;
		}
	</style>
</head>
<body>
<div class="navbar navbar-fixed-top navbar-inverse">
	<div class="navbar-inner">
		<div class="container">
			<a class="brand" href="home.html">
				<spring:message code="home"/>
			</a>
			<ul class="nav"></ul>
			<a class="brand" href="#">
				<spring:message code="newClassTitle"/>
			</a>
			<ul class="nav">
			</ul>
		</div>
	</div>
</div>
<div class="container">
	<div>
		<h1>
			<spring:message code="newMemberTitle"/>
		</h1>
	</div>
	<a class="btn" href="?language=en">English</a>
	<a class="btn" href="?language=gr">Ελληνικά</a>
	<br/>
	<br/>
	<form:form modelAttribute="class">
		<form:errors path="*" cssClass="errorblock" element="div"/>
		<div class="control-group">
			<label><spring:message code="className"/></label>
			<form:input path="className"/>
			<form:errors path="className" cssClass="error"/>
		</div>
		<div class="control-group">
			<label><spring:message code="dayOfClass"/></label>
			<form:select multiple="true" path="day">
				<option value="<spring:message code="Monday"/>"><spring:message code="Monday"/></option>
				<option value="<spring:message code="Tuesday"/>"><spring:message code="Tuesday"/></option>
				<option value="<spring:message code="Wednesday"/>"><spring:message code="Wednesday"/></option>
				<option value="<spring:message code="Thursday"/>"><spring:message code="Thursday"/></option>
				<option value="<spring:message code="Friday"/>"><spring:message code="Friday"/></option>
				<option value="<spring:message code="Saturday"/>"><spring:message code="Saturday"/></option>
				<option value="<spring:message code="Sunday"/>"><spring:message code="Sunday"/></option>
			</form:select>
			<form:errors path="day" cssClass="error"/>
		</div>
		<div class="control-group">
			<label><spring:message code="timeOfClass"/></label>
			<form:input type="time" path="time"/>
			<form:errors path="time" cssClass="error"/>
		</div>
		<div class="control-group">
			<label><spring:message code="classDuration"/></label>
			<form:input path="duration"/>
			<form:errors path="duration" cssClass="error"/>
		</div>
		<div class="control-group">
			<label><spring:message code="classTutor"/></label>
			<form:input path="tutorName"/>
			<form:errors path="tutorName" cssClass="error"/>
		</div>
		<div class="control-group">
			<label><spring:message code="classAdditionalInfo"/></label>
			<form:input cssClass="text-area" path="additionalInfo"/>
			<form:errors path="additionalInfo" cssClass="error"/>
		</div>

		<input type="submit" class="btn" value="<spring:message code="saveButton"/>"/>

	</form:form>
</div>
</body>
</html>
