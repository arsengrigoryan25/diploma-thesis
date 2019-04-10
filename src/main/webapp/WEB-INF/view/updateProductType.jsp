<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/updateProductType" method="post" modelAttribute="dictionaryContent">
    <div class="doc-list">
        <table class="negrTable">
            <tbody>
            <c:forEach items="${productType}" var="type" varStatus="loop">
                <tr>
                    <td><input name="productTypeList[${loop.index}].id" type="text" value="${type.id}"/></td>
                    <td><input name="productTypeList[${loop.index}].name" type="text" value="${type.name}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class=" clearfix">
        <div class="form-group">
            <input id="addProductType" type="submit" value="թարմացնել ապրանքի տիպ" class="btn save btn-primary mt-inp">
        </div>
    </div>
</form:form>
</body>
</html>