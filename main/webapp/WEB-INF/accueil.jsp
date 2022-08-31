
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>wlecom to Accueil</h1>

<form action="" method="post">
<label for="name">name</label>
<input type="text" name="name"/>
<label for="last_name">last_name</label>
<input type="text" name="last_name"/>
<input type="submit" value="*add users*"/>

</form>
<c:forEach items="${ users }" var="user">
<p>name==<c:out value="${ user.name }"/>// last_name
<c:out value="${ user.last_name }"/></p>
</c:forEach>

</body>
</html>