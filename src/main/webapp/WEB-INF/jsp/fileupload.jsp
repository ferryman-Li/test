<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传</title>
</head>
<body>
<div class="content" align="center">
    <h1 align="center">文件上传</h1>
    <form method="post" action="fileuploadValid" enctype="multipart/form-data">
        <table border="0" cellspacing="10" cellpadding="0">
            <tr>
                <td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
            </tr>
            <tr>
                <td>所属模块：</td>
                <td><input type="text" name="moduleName" size="20"></td>
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
                <td>选择一个文件:</td>
            </tr>
            <tr>
                <td><input type="file" name="uploadFile"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="上传"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>