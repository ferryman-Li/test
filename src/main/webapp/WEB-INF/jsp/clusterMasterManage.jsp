<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>操作管理节点</title>

    <%--    <style type="text/css">--%>
    <%--        html, body {--%>
    <%--            width: 100%;--%>
    <%--            height: 100%;--%>
    <%--            margin: 0;--%>
    <%--            padding: 0;--%>
    <%--        }--%>

    <%--        .content {--%>
    <%--            margin: 0 auto; /*水平居中*/--%>
    <%--            position: relative;--%>
    <%--            top: 50%; /*偏移*/--%>
    <%--            transform: translateY(-50%);--%>
    <%--        }--%>

    <%--        body {--%>
    <%--            background: #C7EECE;--%>
    <%--        }--%>

    <%--        a {--%>
    <%--            margin: 25px;--%>
    <%--        }--%>

    <%--        h2 {--%>
    <%--            color: #135eff;--%>
    <%--        }--%>
    <%--    </style>--%>
</head>
<body>
<div class="content">
    <h1 align="center">
        请选择以下选项
    </h1>
    <h2 align="center">
        <input type="button" value="新增管理节点" onclick="javascrtpt:window.location.href='add'">
        <br/><br/>
        <input type="button" value="删除管理节点" onclick="javascrtpt:window.location.href='delete'">
        <br/><br/>
        <input type="button" value="修改管理节点" onclick="javascrtpt:window.location.href='update'">
        <br/><br/>
        <input type="button" value="查看所有管理节点" onclick="javascrtpt:window.location.href='findall'">
        <br/><br/>
        <input type="button" value="按集群名称查询" onclick="javascrtpt:window.location.href='findByClusterName'">
        <br/><br/>
        <input type="button" value="按管理节点IP查询" onclick="javascrtpt:window.location.href='findByMasterIp'">
        <br/><br/>
    </h2>
</div>
</body>
</html>