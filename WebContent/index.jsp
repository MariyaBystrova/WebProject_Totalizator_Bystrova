<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML">
<html>
<head>
<fmt:setLocale value="${sessionScope.local}" />
<fmt:setBundle basename="localization.local" var="loc" />
<fmt:message bundle="${loc}" key="local.totalizator_title" var="totalizator" />
<fmt:message bundle="${loc}" key="local.login" var="login" />
<fmt:message bundle="${loc}" key="local.password" var="password" />
<fmt:message bundle="${loc}" key="local.sign_in" var="sign_in" />
<fmt:message bundle="${loc}" key="local.registration" var="registration" />
<fmt:message bundle="${loc}" key="local.ru" var="ru" />
<fmt:message bundle="${loc}" key="local.en" var="en" />
<fmt:message bundle="${loc}" key="local.remember_me" var="remember_me" />
<fmt:message bundle="${loc}" key="local.enter_system" var="enter_system" />
<fmt:message bundle="${loc}" key="local.remember_me" var="remember" />
<fmt:message bundle="${loc}" key="local.enter_password" var="enter_password" />
<fmt:message bundle="${loc}" key="local.enter_login" var="enter_login" />


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${totalizator}" /></title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="ru" /> 
			<input type="submit" name="local" value="${ru}" class="btn btn-default" />
		</form>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="en" /> <input
				type="submit" name="local" value="${en}" class="btn btn-default">
		</form>
	</div>

	<div class="container">
		<h2>
			<c:out value="${enter_system}" />
		</h2>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="logination" />
			<div class="form-group">
				<div>
					<label for="login"><c:out value="${login}" />:</label>
				</div>
				<div>
					<input type="text" name="login" value="" id="login"
						class="form-control" placeholder="${enter_login}" required="required" />
				</div>
			</div>
			<div class="form-group">
				<div>
					<label for="password"><c:out value="${password}" />:</label>
				</div>
				<div>
					<input type="password" name="password" value="" id="password"
						class="form-control" placeholder="${enter_password}"
						required="required" />
				</div>
			</div>
			<div class="checkbox">
				<label><input type="checkbox"> <c:out value="${remember_me}" /></label>
			</div>
			<div>
				<input type="submit" value="${sign_in}" class="btn btn-default">
			</div>
		</form>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="go-to-registration" /> <span>
				<input type="submit" value="${registration}" class="btn btn-default" />
			</span>
		</form>
	</div>
</body>
</html>