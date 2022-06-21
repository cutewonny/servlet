<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-05-28
  Time: 오후 6:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>/WEB-INF/views/new-form.jsp</title>
</head>
<body>
<!--
상대 경로 : action="save"
절대 경로 : / 로 시작
-->
<p>new-form</p>
<p>urlPatterns = "/servlet-mvc/members/new-form"</p>
<p>urlPatterns = "/servlet-mvc/members/save"</p>

<p>String viewPath = "/WEB-INF/views/new-form.jsp";</p>
<p>String viewPath = "/WEB-INF/views/save-result.jsp";</p>

<form action="save" method="post">
    username: <input type="text" name="username">
    age:     <input type="text" name="age">
    <button type="submit">전송</button>
</form>

</body>
</html>
