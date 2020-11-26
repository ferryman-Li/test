<%@ page import="org.qnit.entity.Template" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示数据</title>

</head>
<body>
<h2 align="center">显示数据</h2>
<c:if test="${!empty template}">
    <table border="1px" width="70%" align="center" cellspacing="0px">
        <tr>
            <th>模板名</th>
            <th>模板內容</th>
            <th>备注</th>
        </tr>
    <%
        Template c = (Template) request.getAttribute("template");
    %>
        <tr align="center">
            <td><%=c.getTemplateName()%></td>
            <td><%=c.getContent()%></td>
            <td><%=c.getRemarks()%></td>
        </tr>
    </table>
</c:if>
</body>
</html>
