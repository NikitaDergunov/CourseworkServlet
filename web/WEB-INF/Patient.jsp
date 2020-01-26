<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="models.PatientModel" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.12.2019
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient</title>
</head>

<body>
<table border="1" style="border-collapse:collapse">
    <tr><th>Name</th><th>PatientID</th><th>Sex</th><th>BT</th><th>Severity</th><th>OrganNeded</th></tr>
    <div class="container4">
            <%Iterator itr;%>
            <% List data4= (List)request.getAttribute("Patients");

        for (itr=data4.iterator(); itr.hasNext();)
        {
            PatientModel patientModel = (PatientModel) itr.next();%>
        <tr><td><%=patientModel.getName() %></td>
            <td><%=patientModel.getId() %></td>
            <td><%=patientModel.getSex() %></td>
            <td><%=patientModel.getBloodType() %></td>
            <td><%=patientModel.getSeverity() %></td>
            <td><%=patientModel.getOrganNeded() %></td>

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
        <th><input type="submit" value="Donors" name="button2" /></th>
        <th><input type="submit" value="MedicalHistory" name="button3" /></th>

    </tr>
</form>
<form action="${pageContext.request.contextPath}/PatientServlet" method="get">
    Delete with PatientID:
    <BR>
    <TEXTAREA NAME="textarea1" ROWS="1"></TEXTAREA>
    <BR>
    <INPUT TYPE="SUBMIT" VALUE="Delete" name="PatientDel">
</FORM>
                <form action="${pageContext.request.contextPath}/PatientServlet" method="get">
                    Insert:
                    <BR>
                    <TEXTAREA NAME="PName" ROWS="1"></TEXTAREA>
                    <TEXTAREA NAME="PPatientID" ROWS="1"></TEXTAREA>
                    <TEXTAREA NAME="PSex" ROWS="1"></TEXTAREA>
                    <TEXTAREA NAME="PBT" ROWS="1"></TEXTAREA>
                    <TEXTAREA NAME="PSeverity" ROWS="1"></TEXTAREA>
                    <TEXTAREA NAME="POrganNeded" ROWS="1"></TEXTAREA>
                    <BR>
                    <INPUT TYPE="SUBMIT" VALUE="Insert" name="PIns">
                </FORM>
</body>
</html>
