<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/24 0024
  Time: 下午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<c:if test="${!empty userList}">
    <c:forEach var="user" items="${userList}">
        广告商：${user.id} &nbsp;&nbsp;广告名称：${user.adName} &nbsp;&nbsp;价格：${user.adPrice} &nbsp;&nbsp;<br>
    </c:forEach>
</c:if>
</body>
</html>