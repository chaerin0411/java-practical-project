<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

%>
<!DOCTYPE>
<html>
<head>
<% 

%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("result")%>입니다.
${result} 입니다
<!-- 
배열:	String[] names = {"dong","yang"};
	request.setAttribute("names", names);
	--------------------------------------
	${names[0]}
	

맵:	Map<String, Ojbect> notice= new HashMap<K,V>();
	notice.put("id", 1);
	notice.put("title", "제목입니다");
	request.setAttribute("notice", notice);
	--------------------------------------
	${notice.title}

 -->

</body>
</html>