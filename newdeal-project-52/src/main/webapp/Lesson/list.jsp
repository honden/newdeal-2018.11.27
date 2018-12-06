<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>게시물</title>
</head>
<body>
	<h1>게시물2</h1>
	<table border='1'>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
		  <th>기간</th>
		  <th>총시간</th>
		</tr>
		<c:forEach items="${list}" var="lesson">
<tr>
  <td>${lesson.no}</td>
  <td>
  <!--  a href="detail?no=${lesson.no}"-->
  ${lesson.title}
  <!--/a-->
  </td>
  <td>
  <!-- a href="detail?no=${lesson.no}"-->
  ${lesson.contents}
  <!--/a-->
  </td>
  <td>${lesson.startDate}~${board.endDate}</td>
  <td>${lesson.totalHours}</td>
</tr>
</c:forEach>
	</table>
	<p></p>
</body>
</html>
