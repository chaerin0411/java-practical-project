<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  String num_ = request.getParameter("n");
  int num = 0;
  if(num_!=null && !num_.equals("")){
		num = Integer.parseInt(num_);}
  String model = ""; 
  if(num%2==0){
	  model = "짝수";
  } else {
	  model = "홀수";
  }
%>
<!DOCTYPE>
<html>
<head>
<% 

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 짝/홀수 판정 </title>
</head>
<body>
<%=model%>입니다.

</body>
</html>