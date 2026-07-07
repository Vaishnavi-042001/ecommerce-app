<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Username: <input type="text" name="username" value="admin"/></label><br/>
        <label>Password: <input type="password" name="password" value="admin"/></label><br/>
        <input type="submit" value="Login"/>
    </form>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
    <p>Hint: use admin/admin</p>
</body>
</html>
