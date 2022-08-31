
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>






<form action="bonjour" method="post">
<p><label for="login"> login : </label>
<input name="login" type="text" id="name" /></p>
<p><label for="pass"> pssword : </label>
<input name="pass" type="password" id="pass" /></p>
<input type="submit"/>
</form>


<c:if test="${ !empty sessionScope.login  && !empty sessionScope.pass }">
<p>   <c:out value="${ sessionScope.login  }"/> </p>
<p>   <c:out value="${ sessionScope.pass }"/> </p>

</c:if>



</body>
</html>