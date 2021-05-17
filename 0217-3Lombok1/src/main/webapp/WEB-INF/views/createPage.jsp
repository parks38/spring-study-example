<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Page</title>
</head>
<body>
create.jsp
<br/>
<%
    String conPath = request.getContextPath();
%>
<form action="<%= conPath %>/create">
    작성자 : <input type="text" name="writer" value="${dto.writer }"><br/>
    내용 : <input type="text" name="content" value="${dto.content }"><br/>
    <input type="submit" value="전송"> <br/>
</form>
</body>
</html>
<!--
request.getContextPath() 는 프로젝트의 경로 를 가져온다.
이프로젝트에서는 /를 의미.
form형식에 맞게 작성자 부분과 내용 부분을 입력하면 그값은 각각
dto.wrtier, dto.content 값들이 되고 validate함수에 의해 데이터 겁증 과정을 거친다.
-->