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
        <form:form action="${pageContext.request.contextPath}/updateProductType" method="post" modelAttribute="dictionaryContent">
            <div class="doc-list">
                <a href="/">Գլխավոր էջ</a>
                <hr>
                <div class="negrTable">
                    <ul>
                    <c:forEach items="${productType}" var="type" varStatus="loop">
                        <li>
                            <span><input name="productTypeList[${loop.index}].id" type="text" value="${type.id}" readonly/></span>
                            <span><input name="productTypeList[${loop.index}].name" type="text" value="${type.name}"/></span>
                        </li>
                    </c:forEach>
                    </ul>
                </div>
            </div>
            <div class=" clearfix">
                <div class="form-group">
                    <button id="addProductType" type="submit" class="btn save btn-primary mt-inp">թարմացնել ապրանքի տիպ</button>
                </div>
            </div>
        </form:form>
    </div>
</div>

</body>
</html>