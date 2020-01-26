<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="models.MHModel" %><%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 11.12.2019
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MedicalHistory</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
    <tr><th>History</th><th>PatientID</th><th>DateOfAdmission</th></tr>
<div class="container4">
       <%Iterator itr;%>
       <% List data4= (List)request.getAttribute("mh");
           for (itr=data4.iterator(); itr.hasNext();)
           {
               MHModel mhModel = (MHModel) itr.next();%>
           <tr><td><%=mhModel.getHistory() %></td>
               <td><%=mhModel.getId() %></td>
               <td><%=mhModel.getDateOfAdmission() %></td></tr>
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
        <th><input type="submit" value="Patients" name="button4" /></th>

    </tr>
</form>
<form action="${pageContext.request.contextPath}/MHServlet" method="get">
    Delete with PatientID:
    <BR>
    <TEXTAREA NAME="textarea1" ROWS="1"></TEXTAREA>
    <BR>
    <INPUT TYPE="SUBMIT" VALUE="Delete" name="MHDel">
</FORM>
<form action="${pageContext.request.contextPath}/MHServlet" method="get">
    Insert:
    <BR>
    <TEXTAREA NAME="MHHistory" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="MHPatientID" ROWS="1"></TEXTAREA>
    <TEXTAREA NAME="MHDateOfAdmission" ROWS="1"></TEXTAREA>
    <BR>
    <INPUT TYPE="SUBMIT" VALUE="Insert" name="MHIns">
</FORM>
</body>
</html>
