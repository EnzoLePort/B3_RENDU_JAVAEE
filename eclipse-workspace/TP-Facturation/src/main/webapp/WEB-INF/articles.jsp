<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Articles</title>
		<%@include file="commons/header.jsp"%>
	</head>
	
	<body>		
		<%@include file="commons/menu.jsp"%>
		
		<table>
			<head>
				<tr>
					<th>N*</th>
					<th>Nom du Produit</th>
					<th>Prix</th>
				</tr>
			</head>
			<c:forEach var="article" items="${articles}" >
				<tr>
					<td><c:out value="${article.numero}"></c:out></td>
					<td><c:out value="${article.nom}"></c:out></td>
					<td><c:out value="${article.prix}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		
		<input type="button" value="AJOUTER UN ARTICLE" onclick="window.location.href='createArticle';" />
		
		<%@include file="commons/footer.jsp"%> 
	</body>
</html>