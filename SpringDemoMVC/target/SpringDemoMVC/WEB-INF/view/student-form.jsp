<%--
  Created by IntelliJ IDEA.
  User: milan
  Date: 20.09.2021
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Resgistration Form</title>
</head>
<body>

    <form:form action="processForm" modelAttribute="student">

        First name: <form:input path="firstName" />

        <br><br>

        Last name: <form:input path="lastName" />
        
        <br><br>

        Country:

        <form:select path="country">

            <form:options items="${student.countryOptions}"/>

        </form:select>
        
        <br><br>

        Favorite Language:

        <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>

        <br><br>

        Linux <form:checkbox path="operatingSystems" value="Linux" />
        Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />

        <br><br>
        
        <input type="submit" value="Submit" />

    </form:form>

</body>
</html>
