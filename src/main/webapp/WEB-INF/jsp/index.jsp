<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PBS管理系统</title>
    
</head>
<body>
    <h1 align="center">
        PBS管理系统
    </h1>
    <br/>
    <h3 align="center">
        <input type="button" value="集群管理节点" onclick="javascrtpt:window.location.href='clusterMasterManage'">
        <br/><br/>
        <input type="button" value="任务脚本管理" onclick="javascrtpt:window.location.href='scriptInfoManage'">
        <br/><br/>
        <input type="button" value="应用模板管理" onclick="javascrtpt:window.location.href='templateManage'">
        <br/><br/>
        <input type="button" value="执行脚本" onclick="javascrtpt:window.location.href='executescript'">
        <br/><br/>
        <input type="button" value="执行模板" onclick="javascrtpt:window.location.href='executetemplate'">
        <br/><br/>
        <input type="button" value="提交命令" onclick="javascrtpt:window.location.href='submitcmd'">

    </h3>
</body>
</html>