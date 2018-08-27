<%--
  Created by IntelliJ IDEA.
  User: Thodoris
  Date: 10-Aug-18
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="rodo"/> </title>
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
				<a class="brand" href="#">
					<spring:message code="home"/>
				</a>
				<ul class="nav"></ul>
			</div>
		</div>
	</div>
	<div class="container">
		<a class="btn" href="?language=en">English</a>
		<a class="btn" href="?language=gr">Ελληνικά</a>
		<br/>
		<br/>
		<div class="hero-unit">
			<div>
				<h1>
					<spring:message code="welcome"/>!
				</h1>
				<p>
					To get started, we need to enter a goal for what we want to exercise for
					today.
				</p>
			</div>
			<a class="btn btn-primary" href="addMember.html">
				<spring:message code="newMemberHeader"/> »
			</a>

			<a class="btn btn-primary" href="addClass.html">
				<spring:message code="newClassTitle"/> »
			</a>

			<a class="btn btn-primary" href="classes.html">
				<spring:message code="classesTitle"/> »
			</a>
		</div>
		<div>
		</div>
	</div>

	<script src="js/jquery-3.3.1.js">
	</script>
	<script src="assets/js/bootstrap.js">
	</script>
</body>
</html>
