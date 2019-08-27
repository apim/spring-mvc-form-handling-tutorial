<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.errMsg {
	color: red;
}
</style>
<title><spring:message code="title.register.label" /></title>
</head>
<body>
	<div align="center">
		<form:form modelAttribute="regData" method="post">
			<table>
				<tr>
					<td><spring:message code="fullName.label" /></td>
					<td><form:input path="fullName" /></td>
					<td><form:errors path="fullName" cssClass="errMsg" /></td>
				</tr>
				<tr>
					<td><spring:message code="age.label" /></td>
					<td><form:input path="age" /></td>
					<td><form:errors path="age" cssClass="errMsg" /></td>
				</tr>
				<tr>
					<td><spring:message code="address.label" /></td>
					<td><form:textarea path="address" /></td>
					<td><form:errors path="address" cssClass="errMsg" /></td>
				</tr>
				<tr>
					<td><spring:message code="sex.label" /></td>
					<td>
						<spring:message code="sex.male.label" var="male" /> 
						<form:radiobutton path="sex" value="Male" label="${male}" /> 
						<spring:message code="sex.female.label" var="female" /> 
						<form:radiobutton path="sex" value="Female" label="${female}" />
					</td>
					<td><form:errors path="sex" cssClass="errMsg" /></td>
				</tr>
				<tr>
					<td><spring:message code="classChoices.label" /></td>
					<td><form:checkboxes path="classChoices" items="${classList}" /></td>
					<td><form:errors path="classChoices" cssClass="errMsg" /></td>
				</tr>
				<tr>
					<td><spring:message code="campus.label" /></td>
					<td><form:select path="campus" items="${campusList}" /></td>
					<td><form:errors path="campus" cssClass="errMsg" /></td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<spring:message code="submit.label" var="submit" /> 
						<input type="submit" value="${submit}">
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>