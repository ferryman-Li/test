<%@ page import="java.util.List" %>
<%@ page import="org.qnit.entity.Template" %>
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
            <th>模板名</th>
            <th>模板內容</th>
            <th>备注</th>
        </tr>
        <!-- 通过循环 显示 数据 -->
        <%
            //获取所有的数据
            List<Template> list = (List<Template>) request.getAttribute("list");

            for (Template c : list) {
        %>
        <tr align="center">
            <td><%=c.getTemplateName()%></td>
            <td><%=c.getContent()%></td>
            <td><%=c.getRemarks()%></td>
        </tr>
        <%
            }
        %>
    </table>
</c:if>
</body>
</html>
