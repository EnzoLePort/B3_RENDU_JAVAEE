<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Clients</title>
		<%@include file="commons/header.jsp"%>
	</head>
	
	<body>		
		<%@include file="commons/menu.jsp"%>
		
		<table>
			<head>
				<tr>
					<th>Nom</th>
					<th>Adresse</th>
				</tr>
			</head>
			<c:forEach var="client" items="${clients}" >
				<tr>
					<td><c:out value="${client.nom}"></c:out></td>
					<td><c:out value="${client.adress}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="button" value="AJOUTER UN CLIENT" onclick="window.location.href='createClient';" />
		
		<%@include file="commons/footer.jsp"%> 
	</body>
</html>