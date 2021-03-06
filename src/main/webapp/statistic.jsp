<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Статистика</title>
    <style>
        table{
            width: 100%;
        }
        table tr{
            width: 100%;
        }
    </style>
</head>
<body>
<div>
    <jsp:include page="blocks/breadcrumbs.jsp"/>
</div>
<table>
    <tbody>
        <c:forEach items="${requestScope.persons}" var="person">
        <tr>
            <td>${person.getFullname()}(${person.id})</td>
            <td>
                <c:if test="${not empty person.getAddresses()}">
                    <c:forEach items="${person.getAddresses()}" var="address" varStatus="loop">
                        ${loop.index+1} адрес: ${address.fullAddress}<br>
                    </c:forEach>
                </c:if>
            </td>
        </tr>
        </c:forEach>
    </tr>
    </tbody>
</table>
</body>
</html>
