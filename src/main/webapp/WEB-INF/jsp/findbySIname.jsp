<%@ page import="org.qnit.entity.Template" %>
<%@ page import="org.qnit.entity.ScriptInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示数据</title>

</head>
<body>
<h2 align="center">显示数据</h2>
<c:if test="${!empty scriptInfo}">
    <table border="1px" width="70%" align="center" cellspacing="0px">
        <tr>
            <th>所属模块</th>
            <th>脚本名</th>
            <th>路径</th>
            <th>状态</th>
            <th>备注</th>
        </tr>
    <%
        ScriptInfo c = (ScriptInfo) request.getAttribute("scriptInfo");
    %>
        <tr align="center">
            <td><%=c.getModuleName()%></td>
            <td><%=c.getScriptName()%></td>
            <td><%=c.getPath()%></td>
            <td><%=c.getStatus()%></td>
            <td><%=c.getRemarks()%></td>
        </tr>
    </table>
</c:if>
</body>
</html>
