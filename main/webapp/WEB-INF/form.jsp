<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="form" method="post">
<label for="nom">nom:</label>
<input name="nom" type="text"/>
<label for="prenom">prenom:</label>
<input name="prenom" type="text"/>
<input type="submit" value="add_employe"/>
</form>




<h1>Utilisateur</h1>
<c:forEach items="${ utilisateurs }" var="employe">
<p>name: <c:out value="${ employe.nom }" /></p>

<p> prenom :<c:out value="${ employe.prenom }"/></p>
<h1>___________________</h1>

</c:forEach>











</body>
</html>