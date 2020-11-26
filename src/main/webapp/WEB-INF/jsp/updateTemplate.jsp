<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改模板信息</title>
</head>
<body>
	<h2 align="center">
		请填写以下信息
	</h2>
	<div id="updateForm" align="center">
		<form action="updateTemplateValid" method="post">
			<table border="0" cellspacing="10" cellpadding="0">
				<tr>
					<td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
				</tr>
				<input type="hidden" name="id" value="${param.id}">
				<tr>
					<td>模板名：</td>
					<td><input type="text" name="templateName" size="20"></td>
				</tr>
				<tr>
					<td>模板内容：</td>
					<td><input type="text" name="content" size="20"></td>
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
</body>
</html>