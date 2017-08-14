<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border = "1">

    <tr>
        <th>CustomerID</th>
        <th>CompanyName</th>
        <th>City</th>

    </tr>

    <c:forEach items = "${cList}" var = "item">

        <tr>
            <td>
            ${item.customerID}
            </td>

        <td>
            ${item.companyName}
        </td>

            <td>
                ${item.city}
            </td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
