<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
  String num_ = request.getParameter("n");
%>
<!DOCTYPE>
<html>
<head>
<% 
  int num = 0;
  if(num_!=null && !num_.equals("")){
	   num = Integer.parseInt(num_);}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(num%2==0){%>
	짝수입니다.
<%} else { %>
	홀수입니다.
<%}%>

</body>
</html>