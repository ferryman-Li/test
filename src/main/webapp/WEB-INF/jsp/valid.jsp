<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>跳转页面</title>

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
    </style>
</head>
<script>
    function timer() {
        var time = document.getElementById("second").innerHTML;
        if (time > 1) {
            document.getElementById("second").innerHTML = time - 1;
        } else {
            location.href = "index"
        }
    }
</script>
<body onload="setInterval('timer()', 1000)">
<div class="content">
    <h3 align="center">
    操作成功，<span id="second" style="color:red;">3</span>秒钟后跳转到首页
    </h3>
</div>
</body>
</html>
