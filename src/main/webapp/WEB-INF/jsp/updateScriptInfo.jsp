<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改脚本信息</title>
</head>
<body>
	<h2 align="center">
		请填写以下信息
	</h2>
	<div id="updateForm" align="center">
		<form action="updateScriptInfoValid" method="post">
			<table border="0" cellspacing="10" cellpadding="0">
				<tr>
					<td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
				</tr>
				<input type="hidden" name="id" value="${param.id}">
				<tr>
					<td>所属模块：</td>
					<td><input type="text" name="clusterName" size="20"></td>
				</tr>
				<tr>
					<td>脚本名：</td>
					<td><input type="text" name="masterIp" size="20"></td>
				</tr>
				<tr>
					<td>路径：</td>
					<td><input type="text" name="userName" size="20"></td>
				</tr>
				<tr>
					<td>状态：</td>
					<td><input type="text" name="userPwd" size="20"></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><input type="text" name="userPwd" size="20"></td>
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