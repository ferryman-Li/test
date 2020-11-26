<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>执行命令</title>
</head>
<body>
<div class="content" align="center">
    <h1 align="center">执行命令</h1>
    <form method="post" action="submitCmdValid" >
        <table border="0" cellspacing="10" cellpadding="0">
            <tr>
                <td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
            </tr>
            <tr>
                <td>管理节点IP:</td>
                <td><input type="text" name="masterIp" size="20"></td>
            </tr>
            <tr>
                <td>命令：</td>
                <td><input type="text" name="cmd" size="20"></td>
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
</body>
</html>