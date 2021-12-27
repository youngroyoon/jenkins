<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>트리</title>
</head>
<body>
    트리구조 데이터
    <ul>
        <c:forEach var="item" items="${treeData}">
            <li>
                <c:forEach var="lv" begin="0" end="${item.depth}">&nbsp</c:forEach>
                ${item.name}
            </li>
        </c:forEach>
    </ul>
</body>
</html>