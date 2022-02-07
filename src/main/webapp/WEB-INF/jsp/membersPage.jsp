<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
      table th, table td {
         padding: 5px;
      }
      .message {
         color: blue;
      }
   </style>
</head>
<body>
<a href="/" style="align-content: center;">Menu</a>
<h2 align="center">Members</h2>
<table border="1">
            <tr>
               <th>User Name</th>
               <th>First Name</th>
               <th>Last Name</th>
               <th>Email</th>
               <th>Gender</th>
            </tr>
            <c:forEach var="member" items="${members}">
       
            <tr >
               <td >${member.userName}</td>
               <td>${member.firstName}</td>
               <td>${member.lastName}</td>
               <td>${member.email}</td>
               <td>${member.gender}</td>
            </tr>	
            </c:forEach>
      </table>
</body>
</html>