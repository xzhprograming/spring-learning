<%--
  Created by IntelliJ IDEA.
  User: 12448
  Date: 2021/5/11
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList = new Array();
        userList.push({name:"zhangsan", age:18});
        userList.push({name:"lisi", age:28});

        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/user/quick15",
            data:JSON.stringify(userList),
            contentType:'application/json;charset=utf-8'
        });
    </script>
</head>
<body>

</body>
</html>
