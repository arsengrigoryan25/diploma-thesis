<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form>
    <div class="doc-list">
        <table class="negrTable">
            <tbody>
            <c:forEach items="${productType}" var="type">
                <tr>
                    <td>${type.id}</td>
                    <td>${type.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</form:form>
<form:form action="${pageContext.request.contextPath}/createProductType">
    <div class="doc-list">
        <input id="typeName" type="text" name="name" class="btn save btn-primary mt-inp">
    </div>
    <div class="form-group">
        <input id="addProductType" type="submit" value="ավելացնել ապրանքի տիպ" class="btn save btn-primary mt-inp">
    </div>
</form:form>
</body>
</html>
