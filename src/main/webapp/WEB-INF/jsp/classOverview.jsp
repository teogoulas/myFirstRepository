<%--
  Created by IntelliJ IDEA.
  User: Thodoris
  Date: 08-Aug-18
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="select" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="className"/></title>
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
					<spring:message code="classOverviewTitle"/>
				</a>
				<ul class="nav">
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<a class="btn" href="?language=en">English</a>
		<a class="btn" href="?language=gr">Ελληνικά</a>
		<br/>
		<br/>
		<form:form modelAttribute="classView">
			<div class="control-group">
				<label><spring:message code="className"/> :</label> ${classView.className}
			</div>
			<div class="control-group">
				<label><spring:message code="classTutor"/> :</label> ${classView.tutorName}
			</div>
			<div class="control-group">
				<label><spring:message code="dayOfClass"/> :</label> ${classView.day}
			<div/>
			<div class="control-group">
				<label><spring:message code="timeOfClass"/> :</label> ${classView.time}
			<div/>
			<div class="control-group">
				<label><spring:message code="classDuration"/> :</label> ${classView.duration}
			<div/>
		</form:form>
		<form:form modelAttribute="memberView">
			<div>
				<table class="table">
					<thead class="thead-light">
						<tr>
							<th scope="col">#</th>
							<th scope="col"><spring:message code="firstName"/></th>
							<th scope="col"><spring:message code="lastName"/></th>
							<th scope="col"><spring:message code="bithday"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${memberView}" var="member">
							<tr>
								<td>${member.studentId}</td><td>${member.studentFirstName}</td><td>${member.studentLastName}</td><td>${member.dateOfBirth}</td><td><a href="editMember.html?memberId=${member.studentId}" class="btn"><spring:message code="edit"/></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</form:form>

		<form method="post">
			<button><spring:message code="back"/></button>
		</form>
	</div>
	<script src="assets/js/bootstrap.js"></script>
</body>
</html>