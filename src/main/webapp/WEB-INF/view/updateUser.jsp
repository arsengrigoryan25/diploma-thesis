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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<div class="container">
    <form:form action="${pageContext.request.contextPath}/updateUser" method="post" modelAttribute="userContent">
        <div class="doc-list">
            <h2>Թարմացնել օգտատերի տվյալները</h2>
            <a href="/">Գլխավոր էջ</a>
            <hr/>
            <div class="negrTable">
                <ul class="list-unstyled row">
                    <c:forEach items="${users}" var="var" varStatus="loop">
                        <li class="form-group col-xs-6">
                            <input name="userList[${loop.index}].id" type="text" class="form-control" value="${var.id}" readonly/>
                            <input name="userList[${loop.index}].name" type="text" class="form-control" value="${var.name}"/>
                            <input name="userList[${loop.index}].lastName" type="text"class="form-control"  value="${var.lastName}"/>

                            <select name="userList[${loop.index}].role" class="form-control">
                                <c:forEach items="${userRoles}" var="role">
                                    <option value="${role.id}" <c:if test="${var.role eq role.id}"> selected="selected" </c:if>>
                                            ${role.role}
                                    </option>
                                </c:forEach>
                            </select>
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input " id="defaultGroupExample1" name="userList[${loop.index}].active"
                                       value="true" checked
                                       <c:if test="${var.active == true}">checked</c:if>>
                                <label class="custom-control-label" for="defaultGroupExample1">ակտիվ</label>
                            </div>
                            <div class="custom-control custom-radio">
                                <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="userList[${loop.index}].active"
                                       value="False"
                                       <c:if test="${var.active == false}">checked</c:if>>
                                <label class="custom-control-label" for="defaultGroupExample2">պասիվ</label>
                            </div>
                            <input name="userList[${loop.index}].username" type="text" class="form-control" value="${var.username}"/>
                            <input name="userList[${loop.index}].password" type="text" class="form-control" value="${var.password}"/>
                            <hr/>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class=" clearfix">
            <div class="form-group">
                <input id="addProductType" type="submit" value="թարմացնել ապրանքի տիպ" class="btn save btn-primary mt-inp">
            </div>
        </div>
        <label>${error}</label>
    </form:form>
</div>
</body>
</html>
