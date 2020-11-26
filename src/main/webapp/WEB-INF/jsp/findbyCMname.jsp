<%@ page import="org.qnit.entity.ClusterMaster" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示数据</title>

</head>
<body>
<h2 align="center">显示数据</h2>
<c:if test="${!empty clusterMaster}">
    <table border="1px" width="70%" align="center" cellspacing="0px">
        <tr>
            <th>集群名称</th>
            <th>管理节点IP</th>
            <th>用户名</th>
            <th>密码</th>
        </tr>
    <%
        ClusterMaster c = (ClusterMaster) request.getAttribute("clusterMaster");
    %>
        <tr align="center">
            <td><%=c.getClusterName()%></td>
            <td><%=c.getMasterIp()%></td>
            <td><%=c.getUserName()%></td>
            <td><%=c.getUserPwd()%></td>
        </tr>
    </table>
</c:if>
</body>
</html>
