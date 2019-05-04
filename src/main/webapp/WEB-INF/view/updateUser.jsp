<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/updateUser" method="post" modelAttribute="userContent">
    <div class="doc-list">
        <a href="/">Գլխավոր էջ</a>
        <table class="negrTable">
            <tbody>
            <c:forEach items="${users}" var="user" varStatus="loop">
                <tr>
                    <td><input name="usersList[${loop.index}].id" type="text" value="${user.id}" readonly/></td>
                    <td><input name="usersList[${loop.index}].name" type="text" value="${user.name}"/></td>
                    <td><input name="usersList[${loop.index}].lastName" type="text" value="${user.lastName}"/></td>
                    <td><select name="usersList[${loop.index}].role" class="form-control">
                        <c:forEach items="${userRoles}" var="role">
                            <option value="${role.role}" <c:if test="${user.role eq role.id}"> selected="selected" </c:if>>
                                    ${role.role}
                            </option>
                        </c:forEach>
                    </td></select>
                    <td>
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="usersList[${loop.index}].active" value="true" checked
                                   <c:if test="${user.active == true}">checked</c:if>>
                            <label class="custom-control-label" for="defaultGroupExample1">ակտիվ</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="usersList[${loop.index}].active" value="False"
                                   <c:if test="${user.active == false}">checked</c:if>>
                            <label class="custom-control-label" for="defaultGroupExample2">պասիվ</label>
                        </div>
                    </td>
                    <td><input name="usersList[${loop.index}].username" type="text" value="${user.username}"/></td>
                    <td><input name="usersList[${loop.index}].password" type="text" value="${user.password}"/></td>
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
    <label>${error}</label>
</form:form>
</body>
</html>