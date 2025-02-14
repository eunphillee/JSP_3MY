<%@page import="test.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connection 테스트</title>
</head>
<body>
<h2>Connection 테스트</h2>
<!--테스트  -->
<%
	CustomerDao dao = CustomerDao.getInstance();
	int result = dao.delete("zzzz");
	pageContext.setAttribute("result", result);
%>
	<c:if test="${result==1 }"	>
		<h3> 사용자 해지 완료 !!</h3>
	</c:if>
	<c:if test="${result==0 }"	>
		<h3> 사용자 해지 실패!! 지정된 사용자 없음</h3>
	</c:if>


</body>
</html>