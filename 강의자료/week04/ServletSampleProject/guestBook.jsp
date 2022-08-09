<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 작성</title>
</head>
<body>
<form action="guest" method="post">
	<div>방문자 : <input type="text" name="vistor"><p>
		  내용 : <textarea name="contents" rows="5" cols="20"></textarea><br>
		  <input type="submit" value="작성완료">
	</div>
</form>
</body>
</html>