<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Hi! Please log in</h2>
<%--    <form:form action="saveEmployee">--%>
<%--        &lt;%&ndash;Невидимое поле чтобы ее заполнило id&ndash;%&gt;--%>
<%--        <form:hidden path="id"/>--%>

<%--        Name <form:input path="name"/>--%>
<%--        <br><br>--%>
<%--        Surname <form:input path="surname"/>--%>
<%--        <br><br>--%>
<%--        <input type="submit" value="ok">--%>
<%--    </form:form>--%>

    <input type="button" value = "Teacher" onclick = " window.location.href = '/teacher' " />
    <br>
    <input type="button" value = "Student" onclick = " window.location.href = '/student' " />


    <h2>All Employees</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
        </tr>
        <c:forEach var="emp" items="${allT}">
<%--            &lt;%&ndash;Создаем ссылку&ndash;%&gt;--%>
<%--            <c:url var="updateButton" value="/updateInfo">--%>
<%--                <c:param name="empId" value="${emp.id}"/>--%>
<%--            </c:url>--%>

<%--            <c:url var="deleteButton" value="/deleteEmployee">--%>
<%--                <c:param name="empId" value="${emp.id}"/>--%>
<%--            </c:url>--%>

            <tr>
                <td>${emp.name}</td>
                <td>${emp.surname}</td>
                <td>${emp.description}</td>
<%--                <td>--%>
<%--                    <input type="button" value="update"--%>
<%--                           onclick="window.location.href = '${updateButton}'"/>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <input type="button" value="delete"--%>
<%--                           onclick="window.location.href = '${deleteButton}'"/>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
