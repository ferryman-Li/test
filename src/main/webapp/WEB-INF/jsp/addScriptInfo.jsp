<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>新增脚本信息</title>

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
        请填写以下信息
    </h2>
    <div id="addScriptInfoForm" align="center">
        <form action="addScriptInfoValid" method="post">
            <table border="0" cellspacing="10" cellpadding="0">
                <tr>
                    <td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
                </tr>
                <tr>
                    <td>所属模块：</td>
                    <td><input type="text" name="moduleName" size="20"></td>
                </tr>
                <tr>
                    <td>脚本名：</td>
                    <td><input type="text" name="scriptName" size="20"></td>
                </tr>
                <tr>
                    <td>路径：</td>
                    <td><input type="text" name="path" size="20"></td>
                </tr>
                <tr>
                    <td>状态：</td>
                    <td><input type="text" name="status" size="20"></td>
                </tr>
                <tr>
                    <td>备注：</td>
                    <td><input type="text" name="remarks" size="20"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div align="center">
                            <input type="submit" value="录入">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="reset" value="重置">
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>