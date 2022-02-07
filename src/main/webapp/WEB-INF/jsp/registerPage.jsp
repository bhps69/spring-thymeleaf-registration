<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/register" method="post" >
<table>
<tr>
<td>UserName</td>
<td><input type="text" id="userName" name="userName"></td>
<td></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" id="password" name="password"></td>
<td></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type="password" id="confirmPassword" name="confirmPassword"></td>
<td></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" id="email" name="email"></td>
<td></td>
</tr>
<tr>
<td>First Name</td>
<td><input type="text" id="firstName" name="firstName"></td>
<td></td>
</tr>
<tr>
<td>lastName</td>
<td><input type="text" id="lastName" name="lastName"></td>
<td></td>
</tr>
<tr>
<td></td>
<td><select name="gender" id="gender">
	<option value="">---</option>
	<option value="M">Male</option>
	<option value="F">Female</option>
</select></td>
<td></td>
</tr>
<tr>
<td>CountryCode</td>
<td><select>
<option value=""></option>
<c:forEach items="${countries}" var="country">
<option value="${country.countryCode}">${country.countryName}</option>
</c:forEach>
</select>
</td>
<td></td>
</tr>
<tr>
<td>&nbsp;</td>
<td><input type="submit" value="Submit"/></td>

<td><a href="/"><input type="button" value="Cancel" ></a></td>

</tr>
<tr>
<td></td>
<td></td>
<td></td>
</tr>

</table>
</form>
</body>
</html> 	