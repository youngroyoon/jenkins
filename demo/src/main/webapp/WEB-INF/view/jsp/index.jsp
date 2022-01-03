<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <style type="text/css">
        body {background-color: #ffffff;}
    </style>
    <title></title>
</head>
<body>

<main role="main" class="container">
    <div class="bom-template-center">
        <h1>코딩테스트1112221</h1>
        <p class="lead">
            안녕하세요<br/>
            <b><c:out value="${corp}" /></b>에 오신것을 환영합니다.
        </p>
    </div>

    <a href="/tree" title="">트리화면 이동</a><br>
    <a href="/e500" title="">에러화면 이동</a><br>
    <a href="/lotto" title="">로또화면 이동</a>

</main>

</body>
</html>