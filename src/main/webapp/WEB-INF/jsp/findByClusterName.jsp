<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询管理节点信息</title>

    <style type="text/css">
        html, body {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
        }

        .content {
            margin: 0 auto; /*水平居中*/
            position: relative;
            top: 50%; /*偏移*/
            transform: translateY(-50%);
        }

        a {
            margin: 25px;
        }

    </style>
</head>
<body>
<div class="content">
    <h2 align="center">
        查询管理节点信息
    </h2>
    <div align="center">
        <p>
            （请输入集群名进行查询）
        </p>
        <form method="POST" action="findByClusterNameValid">
            <p>
                集群名：<input type="text" name="clusterName">
            </p>
            <%--            <p>--%>
            <%--                <a class="btn btn-primary " href="result">查询</a>--%>
            <%--            </p>--%>
            <p>
                <input type="submit" value="提交">
            </p>
        </form>
    </div>
</div>
</body>
</html>
