<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<body>
    <main role="main" class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="error-template">
                    <h1>Oops!</h1>

                    <img src="/image/error.png"/>

                    <div class="error-actions">
                        <a href="/" class="btn btn-outline-primary"><span class="glyphicon glyphicon-home"></span> Take Me Home </a>
                    </div>
                    <br>
                    <div>
                        <h2><c:out value="${errorTitle}"/></h2>
                        <c:out value="${errorMag}"/>
                    </div>
                </div>
            </div>
        </div>
    </main>
</body>
</html>