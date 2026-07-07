<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Checkout</title>
</head>
<body>
    <h2>Checkout</h2>

    <c:if test="${not empty message}">
        <p style="color:green;">${message}</p>
        <a href="${pageContext.request.contextPath}/catalog">Continue Shopping</a> |
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:if>

    <c:if test="${empty message}">
        <h3>Order Summary</h3>
        <table border="1">
            <tr><th>Name</th><th>Price</th></tr>
            <c:forEach var="item" items="${cart}">
                <tr><td>${item.name}</td><td>$${item.price}</td></tr>
            </c:forEach>
        </table>
        <p><strong>Total: $${cart.stream().map(item -> item.price).sum()}</strong></p>
        <form action="${pageContext.request.contextPath}/checkout" method="post">
            <input type="submit" value="Place Order"/>
        </form>
        <a href="${pageContext.request.contextPath}/cart">Back to Cart</a>
    </c:if>
</body>
</html>
