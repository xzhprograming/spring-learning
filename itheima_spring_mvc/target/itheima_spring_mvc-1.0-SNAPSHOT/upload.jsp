<%--
  Created by IntelliJ IDEA.
  User: 12448
  Date: 2021/5/12
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        名称<input type="text" name="username"><br>
        文件1<input type="file" name="uploadFile"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
