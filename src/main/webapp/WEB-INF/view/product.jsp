<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/createTypeProduct">

    <div class="doc-list">
        <table class="negrTable">
            <tbody>
            <c:forEach items="${typeProducts}" var="type">
                <tr>
                    <td>${type.id}</td>
                    <td>${type.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class=" clearfix">
        <div class="form-group">
            <input id="addRow" type="submit" value="ավելացնել տող" class="btn save btn-primary mt-inp">
        </div>
    </div>
    <div class=" clearfix">
        <div class="form-group">
            <input id="addProductType" type="submit" value="ավելացնել ապրանքի տիպ"  class="btn save btn-primary mt-inp">
        </div>
    </div>
</form:form>
</body>
</html>