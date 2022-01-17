<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>로또</title>
</head>
<body>
    로또 데이터ㅁㅁㅁ
    <ul>
        <c:forEach var="list" items="${lottoData}">
	        <c:forEach items="${list}" var="item">
				${item}
			</c:forEach>
			<br/>
        </c:forEach>
    </ul>
</body>
</html>