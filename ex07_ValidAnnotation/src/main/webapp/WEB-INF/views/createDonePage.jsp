<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
createDonePage.jsp
<%
    String conPath = request.getContextPath();
    out.println(conPath);
%>
<br>
이름 : ${dto.writer }입니다.<br>
내용 : ${dto.content } 입니다.
</body>
</html>
