<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>操作模板</title>

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
    <h2 align="center">
        请选择以下选项
    </h2>
    <h3 align="center">
        <input type="button" value="新增模板" onclick="javascrtpt:window.location.href='addTemplate'">
        <br/><br/>
        <input type="button" value="修改模板" onclick="javascrtpt:window.location.href='updateScriptInfo'">
        <br/><br/>
        <input type="button" value="查询所有模板" onclick="javascrtpt:window.location.href='findallTemplate'">
        <br/><br/>
        <input type="button" value="根据模板名查询模板" onclick="javascrtpt:window.location.href='findByTemplatename'">
        <br/><br/>
        <input type="button" value="刪除模板" onclick="javascrtpt:window.location.href='deleteTemplate'">
    </h3>
</div>
</body>
</html>