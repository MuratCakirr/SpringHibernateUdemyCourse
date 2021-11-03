<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 20.09.2021
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>

The student is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes: ${customer.freePasses}

<br><br>

Postal code: ${customer.postalCode}

<br><br>

Course code: ${customer.courseCode}

</body>
</html>
