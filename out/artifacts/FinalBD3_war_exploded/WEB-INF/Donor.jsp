<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="models.DonorModel" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.12.2019
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Donor</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
    <tr><th>Sex</th><th>BloodType</th><th>Status</th><th>OrganID</th><th>DonorID</th></tr>
<div class="container4">
    <%Iterator itr;%>
    <% List data4= (List)request.getAttribute("Donor");
        for (itr=data4.iterator(); itr.hasNext();)
        {
            DonorModel donorModel = (DonorModel) itr.next();%>
    <tr><td><%=donorModel.getSex() %></td>
        <td><%=donorModel.getBloodType() %></td>
        <td><%=donorModel.getStatus() %></td>
        <td><%=donorModel.getOrganID() %></td>
        <td><%=donorModel.getId() %></td></tr>
    <%}%>
</div>
</table>
<form action="${pageContext.request.contextPath}/jsp">
    <tr>
        <th><input type="submit" value="Menu" name="button" /></th>
    </tr>
</form>
<form action="${pageContext.request.contextPath}/main" method="get">
    <tr>
        <th><input type="submit" value="Organs" name="button1" /></th>
        <th><input type="submit" value="MedicalHistory" name="button3" /></th>
        <th><input type="submit" value="Patients" name="button4" /></th>

    </tr>
</form>
<form action="${pageContext.request.contextPath}/DonorServlet" method="get">
    Delete with DonorID:
    <BR>
    <TEXTAREA NAME="textarea1" ROWS="1"></TEXTAREA>
    <BR>
    <INPUT TYPE="SUBMIT" VALUE="Delete" name="DonorDel">
</FORM>
</FORM>
<form action="${pageContext.request.contextPath}/DonorServlet" method="get">
    Insert:
    <BR>
    <TEXTAREA NAME="DSex" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="DBloodType" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="DStatus" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="DOrganID" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="DDonorID" ROWS="1"></TEXTAREA>
    <BR>
    <INPUT TYPE="SUBMIT" VALUE="Insert" name="DIns">
</FORM>
</body>
</html>
