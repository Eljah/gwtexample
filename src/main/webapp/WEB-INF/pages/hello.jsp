<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Список товаров</h2>

<core:forEach var="good" items="${goods}">
    ${good.id} ${good.name} ${good.bought} <a href="buy?id=${good.id}">Купить</a> <br>
</core:forEach>

<br>

<a href="/hellogwt/resources.html/HelloGWT.html">Admin</a>

</body>
</html>
