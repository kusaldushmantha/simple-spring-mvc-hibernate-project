<%--
  User: Kusal
  Date: 4/13/2020
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Add Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>


<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relations Manager</h2>
    </div>
</div>

<div id="container">
    <h2>Add Customer</h2>

    <form:form action="saveCustomer" modelAttribute="customer" method="post">

        <form:hidden path="id"/> <!-- This line sets the associated data with the customer -->

        <table>
            <tbody>
            <tr>
                <td><label>First Name :</label></td>
                <td><form:input path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last Name :</label></td>
                <td><form:input path="lastName"/></td>
            </tr>
            <tr>
                <td><label>Email :</label></td>
                <td><form:input path="email"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="save" class="save"></td>
            </tr>
            </tbody>
        </table>
    </form:form>

    <div style="clear: both"></div>

    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
    </p>
</div>

</body>

</html>