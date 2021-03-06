<%--
  User: Kusal
  Date: 4/13/2020
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customers</title>

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM - Customer Relations Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <input type="button" value="Add Customer"
               onclick="window.location.href = 'showFormForAdd'; return false;"
               class="add-button"/>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Update</th>
            </tr>

            <c:forEach var="tempCustomer" items="${customers}">

                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                    <c:param name="customerName" value="${tempCustomer.firstName}${tempCustomer.lastName}"/>
                </c:url>

                <c:url var="deleteLink" value="/customer/deleteCustomer">
                    <c:param name="customerId" value="${tempCustomer.id}"/>
                </c:url>

                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>

                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if ( !(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a>
                    </td>

                </tr>
            </c:forEach>

        </table>
    </div>
</div>

</body>

</html>
