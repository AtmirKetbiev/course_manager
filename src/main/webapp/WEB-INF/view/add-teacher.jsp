<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Add new teacher</h2>
    <form:form modelAttribute="teacher">
        <form:hidden path="id"/>
        Name <form:input path="name"/>
        <br><br>
        Surname <form:input path="surname"/>
        <br><br>
        Department <form:input path="description"/>
        <br><br>
        <input type="submit" value="ok">
    </form:form>

    <br><br>
</body>
</html>
