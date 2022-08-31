<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul><c:forEach items="${ articls }" var="a">
<li> N° : <c:out value="${ a.n }"/> ******** owner : <c:out value="${ a.owner }"/> ********lang° : <c:out value="${ a.lang }"/> </li>

</c:forEach>
</ul>


<h1> yes </h1>

</body>
</html>