<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Spring Security Example </title>
</head>
<body>
Add user
<form th:action="/registration" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="radio" id="USER" name="role" value="USER">
    <input type="radio" id="ADMIN" name="role" value="ADMIN">
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>