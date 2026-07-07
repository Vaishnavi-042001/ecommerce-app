<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Product Catalog</title>
</head>
<body>
    <h2>Welcome, ${sessionScope.loggedInUser}!</h2>
    <a href="${pageContext.request.contextPath}/logout">Logout</a> |
    <a href="${pageContext.request.contextPath}/cart">View Cart</a>

    <h3>Products</h3>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Description</th><th>Price</th><th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>$${product.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/addToCart?id=${product.id}">Add to Cart</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
