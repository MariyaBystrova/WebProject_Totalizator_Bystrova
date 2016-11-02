<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/taglib.tld" prefix="table-tag"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>User welcome page</title>

<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.hello_user" var="hello" />
<fmt:message bundle="${loc}" key="local.log_out" var="logout" />
<fmt:message bundle="${loc}" key="local.toto_coupon" var="toto_coupon" />
<fmt:message bundle="${loc}" key="local.date" var="date" />
<fmt:message bundle="${loc}" key="local.match" var="match" />
<fmt:message bundle="${loc}" key="local.make_bet" var="make_bet" />
<fmt:message bundle="${loc}" key="local.ru" var="ru" />
<fmt:message bundle="${loc}" key="local.en" var="en" />
<fmt:message bundle="${loc}" key="local.general" var="general" />
<fmt:message bundle="${loc}" key="local.toto" var="toto" />

</head>
<body>
	<div class="container">
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="ru" /> <input
				type="submit" name="local" value="${ru}" class="btn btn-default" />
		</form>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="en" /> <input
				type="submit" name="local" value="${en}" class="btn btn-default">
		</form>
	</div>
	<div class="container">
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="logout"> <input
				type="submit" value="${logout}" class="btn btn-default">
		</form>
	</div>
	<ul class="nav nav-tabs" role="tablist">
		<li class="active"><a href="?command=go-to-general"><c:out
					value="${general}" /></a></li>
		<li><a href="?command=show_coupon_matches"><c:out
					value="${toto}" /></a></li>
	</ul>
	<div>
		<h2>
			<c:out value="${hello}" />
		</h2>
	</div>

</body>
</html>