<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>

<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="localization.local" var="loc"/>
<fmt:message bundle="${loc}" key="local.first_name" var="first_name" />
<fmt:message bundle="${loc}" key="local.last_name" var="last_name"/>
<fmt:message bundle="${loc}" key="local.create_login" var="create_login"/>
<fmt:message bundle="${loc}" key="local.create_password" var="create_password"/>
<fmt:message bundle="${loc}" key="local.confirm_password" var="confirm_password"/>
<fmt:message bundle="${loc}" key="local.gender" var="gender"/>
<fmt:message bundle="${loc}" key="local.unknown" var="unknown"/>
<fmt:message bundle="${loc}" key="local.male" var="male"/>
<fmt:message bundle="${loc}" key="local.female" var="female"/>
<fmt:message bundle="${loc}" key="local.email" var="email"/>
<fmt:message bundle="${loc}" key="local.country" var="country"/>
<fmt:message bundle="${loc}" key="local.city" var="city"/>
<fmt:message bundle="${loc}" key="local.address" var="address"/>
<fmt:message bundle="${loc}" key="local.mandatory_fields" var="mandatory_fields"/>
<fmt:message bundle="${loc}" key="local.register" var="register"/>
<fmt:message bundle="${loc}" key="local.ru" var="ru"/>
<fmt:message bundle="${loc}" key="local.en" var="en"/>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="ru" />
			<input type="submit" name="local" value="${ru}" class="btn btn-default"/>
		</form>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="en" />
			<input type="submit" name="local" value="${en}" class="btn btn-default" >
		</form>
	</div>

	<div class="container">
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="registration" />
			<div>
				<div>
					<label for="first_name"><c:out value="${first_name}" /> *</label>
				</div>
				<div>
					<input type="text" name="firstName" id="first_name" class="form-control"
						required="required" />
				</div>
			</div>
			<div>
				<div>
					<label for="last_name"><c:out value="${last_name}" /> *</label>
				</div>
				<div>
					<input type="text" name="lastName" id="last_name" class="form-control"
						required="required" />
				</div>
			</div>
			<div>
				<div>
					<label for="login"><c:out value="${create_login}" /> *</label>
				</div>
				<div>
					<input type="text" name="login" value="" id="login" class="form-control"
						required="required" />
				</div>
			</div>
			<div>
				<div>
					<label for="password"><c:out value="${create_password}" /> *</label>
				</div>
				<div>
					<input type="password" name="password" value="" id="password" class="form-control"
						required="required" />
				</div>
			</div>
			<div>
				<div>
					<label for="rpassword"><c:out value="${confirm_password}" /> *</label>
				</div>
				<div>
					<input type="password" name="passwordAgain" value="" id="rpassword" class="form-control"
						required="required" />
				</div>
			</div>
			<div>
				<div>
					<label for="sex"><c:out value="${gender}" /></label>
				</div>
				<div>
					<select name="sex" id="sex" class="form-control">
						<option value="unknown" selected><c:out value="${unknown}" /></option>
																										<!-- ???????? -->
						<option value="M"><c:out value="${male}" /></option>
						<option value="F"><c:out value="${female}" /></option>
					</select>
				</div>
			</div>
			<div>
				<div>
					<label for="email"><c:out value="${email}" /> *</label>
				</div>
				<div>
					<input type="email" name="email" value="" id="email" class="form-control"
						required="required" />
				</div>
			</div>
			<div>
				<div>
					<label for="country"><c:out value="${country}" /> *</label>
				</div>
				<div>
					<input type="text" name="country" value="" id="country" class="form-control"
						required="required" />
					<!-- make a list -->
				</div>
			</div>
			<div>
				<div>
					<label for="city"><c:out value="${city}" /></label>
				</div>
				<div>
					<input type="text" name="city" value="" id="city" class="form-control"/>
				</div>
			</div>
			<div>
				<div>
					<label for="address"><c:out value="${address}" /></label>
				</div>
				<div>
					<input type="text" name="address" value="" id="address" class="form-control"/>
				</div>
			</div>

			<div>
				<input type="submit" value="${register}" class="btn btn-default">
			</div>

			<div>
				<span>* <c:out value="${mandatory_fields}" /></span>
			</div>
		</form>
	</div>

</body>
</html>