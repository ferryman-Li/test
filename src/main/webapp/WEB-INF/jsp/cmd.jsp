<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>显示数据</title>

</head>
<body>
<h2 align="center">显示数据</h2>
<c:if test="${!empty execute}">
    <table border="1px" width="70%" align="center" cellspacing="0px">
        <tr>
            <th>返回结果</th>
        </tr>
    <%
        String c = (String) request.getAttribute("execute");
    %>
        <tr align="center">
            <td><%=c%></td>
        </tr>
    </table>
</c:if>
</body>
</html>
