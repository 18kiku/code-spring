<%--
  Created by IntelliJ IDEA.
  User: hwangjeonghwan
  Date: 2022/09/06
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">

    <div>
        <input type="file" name="files">
    </div>
    <div>
        <input type="file" name="files">
    </div>
    <div>
        <input type="file" name="files">
    </div>
    <div>
        <input type="file" name="files">
    </div>
    <div>
        <input type="file" name="files">
    </div>
    <div>
        <input type="submit">
    </div>
</form>
</body>
</html>
