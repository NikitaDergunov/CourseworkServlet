<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="models.OrganModel"%>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.12.2019
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Organ</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
    <tr><th>BloodType</th><th>Size</th><th>ExpirationDAte</th><th>Type</th><th>PatientID</th><th>DonorID</th><th>OrganID</th></tr>
    <div class="container4">
        <%Iterator itr;%>
        <% List data4= (List)request.getAttribute("organ");

            for (itr=data4.iterator(); itr.hasNext();)
            {
                OrganModel organModel = (OrganModel) itr.next();%>
        <tr><td><%= organModel.getBloodType()%></td>
            <td><%=organModel.getSize() %></td>
            <td><%=organModel.getExpirationDate() %></td>
            <td><%=organModel.getType() %></td>
            <td><%=organModel.getPatientID()%></td>
            <td><%=organModel.getDonorID() %></td>
            <td><%=organModel.getId() %></td></tr>
            <%}%>
    </div>
</table>
<form action="${pageContext.request.contextPath}/jsp">
    <tr>
<th><input type="submit" value="Menu" name="button1" /></th>
    </tr>
</form>
<form action="${pageContext.request.contextPath}/main" method="get">
    <tr>

        <th><input type="submit" value="Donors" name="button2" /></th>
        <th><input type="submit" value="MedicalHistory" name="button3" /></th>
        <th><input type="submit" value="Patients" name="button4" /></th>
    </tr>
</form>
    <form action="${pageContext.request.contextPath}/OrganServlet" method="get">
        Delete with OrganID:
        <BR>
        <TEXTAREA NAME="textarea1" ROWS="1"></TEXTAREA>
        <BR>
        <INPUT TYPE="SUBMIT" VALUE="Delete" name="OrganDel">
    </FORM>
</FORM>
<form action="${pageContext.request.contextPath}/OrganServlet" method="get">
    Insert:
    <BR>
    <TEXTAREA NAME="OBloodType" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="OSize" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="OExpirationDAte" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="OType" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="OPatientID" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="ODonorID" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="OOrganID" ROWS="1"></TEXTAREA>
    <BR>
    <INPUT TYPE="SUBMIT" VALUE="Insert" name="OIns">
</FORM>
</body>
</html>
