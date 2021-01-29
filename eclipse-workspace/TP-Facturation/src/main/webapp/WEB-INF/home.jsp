<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Facturations</title>
		<%@include file="commons/header.jsp"%>
	</head>
	
	<body>		
		<%@include file="commons/menu.jsp"%>
		
		List factures :
		
		<table>
			<c:forEach var="factures" items="${facture}" >
				<tr>
					<td><c:out value="${facture.date}"></c:out></td>
					<td><c:out value="${facture.numero}"></c:out></td>
					<td><c:out value="${facture.prix}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		
		<%@include file="commons/footer.jsp"%> 
	</body>
</html>