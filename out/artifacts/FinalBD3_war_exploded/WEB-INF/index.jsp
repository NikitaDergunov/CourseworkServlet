
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 08.12.2019
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Menu</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/main" method="get">
<tr>
    <th><input type="submit" value="Organs" name="button1" /></th>
    <th><input type="submit" value="Donors" name="button2" /></th>
    <th><input type="submit" value="MedicalHistory" name="button3" /></th>
    <th><input type="submit" value="Patients" name="button4" /></th>
</tr>
</form>
</body>
</html>
