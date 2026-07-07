<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
    <h2>Your Cart</h2>
    <a href="${pageContext.request.contextPath}/catalog">Continue Shopping</a> |
    <a href="${pageContext.request.contextPath}/logout">Logout</a>

    <c:choose>
        <c:when test="${empty cart}">
            <p>Your cart is empty.</p>
        </c:when>
        <c:otherwise>
            <table border="1">
                <tr>
                    <th>Name</th><th>Description</th><th>Price</th>
                </tr>
                <c:forEach var="item" items="${cart}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>$${item.price}</td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <a href="${pageContext.request.contextPath}/checkout">Proceed to Checkout</a>
        </c:otherwise>
    </c:choose>
</body>
</html>
