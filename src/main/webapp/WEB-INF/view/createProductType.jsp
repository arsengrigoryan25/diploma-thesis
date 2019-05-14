<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-offset-2 col-xs-8">
            <form:form>
                <div class="doc-list">
                    <a href="/">Գլխավոր էջ</a>
                    <hr>
                    <div class="negrTable">
                        <ul class="list-unstyled">
                            <c:forEach items="${productType}" var="type">
                                <li>
                                    <span>${type.id}</span>
                                    <span>${type.name}</span>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </form:form>
            <form:form action="${pageContext.request.contextPath}/createProductType">
                <div class="doc-list form-group">
                    <input id="typeName" type="text" name="name" class="mt-inp form-control">
                </div>
                <div class="form-group">
                    <button id="addProductType" type="submit" class="btn save btn-primary mt-inp">Ավելացնել ապրանքի տիպ</button>
                </div>
            </form:form>
            <label>${error}</label>
        </div>
    </div>
</div>

</body>
</html>
