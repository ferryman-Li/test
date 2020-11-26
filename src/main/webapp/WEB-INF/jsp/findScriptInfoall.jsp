<%@ page import="org.qnit.entity.ClusterMaster" %>
<%@ page import="java.util.List" %>
<%@ page import="org.qnit.entity.ScriptInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示所有</title>

</head>
<body>
<h2 align="center">显示所有</h2>
<c:if test="${!empty list}">
    <table border="1px" width="70%" align="center" cellspacing="0px">
        <tr>
            <th>所属模块</th>
            <th>脚本名</th>
            <th>路径</th>
            <th>状态</th>
            <th>备注</th>
        </tr>
        <!-- 通过循环 显示 数据 -->
        <%
            //获取所有的数据
            List<ScriptInfo> list = (List<ScriptInfo>) request.getAttribute("list");

            for (ScriptInfo c : list) {
        %>
        <tr align="center">
            <td><%=c.getModuleName()%></td>
            <td><%=c.getScriptName()%></td>
            <td><%=c.getPath()%></td>
            <td><%=c.getStatus()%></td>
            <td><%=c.getRemarks()%></td>
        </tr>
        <%
            }
        %>
    </table>
</c:if>
</body>
</html>
