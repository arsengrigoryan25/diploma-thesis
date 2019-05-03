<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form action="${pageContext.request.contextPath}/createUser">
    <label>${error}</label>
    <div class="doc-list">
        <a href="/">Գլխավոր էջ</a>
        <table class="negrTable">
            <tbody>
            <tr>
                <td>Անուն</td>
                <td><input id="nameId" name="name" type="text" class="form-control" value="${userEntity.name}"/></td>
            </tr>
            <tr>
                <td>Ազգանուն</td>
                <td><input id="lastNameId" name="lastName" type="text" class="form-control" value="${userEntity.name}"/></td>
            </tr>
            <tr>
                <td>Կարգավիճակ</td>
                <td>
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="adminRoleId" name="status" value="true" checked>
                        <label class="custom-control-label" for="defaultGroupExample1">Ադմինիստրատոր</label>
                    </div>

                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="userRoleId" name="status" value="False">
                        <label class="custom-control-label" for="defaultGroupExample2">Օգտագոչծող</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td> </td>
                <td>
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="active" value="true" checked>
                        <label class="custom-control-label" for="defaultGroupExample1">ակտիվ</label>
                    </div>

                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="active" value="False">
                        <label class="custom-control-label" for="defaultGroupExample2">պասիվ</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>Օգտվողի անուն</td>
                <td><input id="usernameId" name="username" type="text" class="form-control"/></td>
            </tr>
            <tr>
                <td>Գաղտնաբառ</td>
                <td><input id="passwordId" name="password" type="password" class="form-control"/></td>
            </tr>
            </tbody>
        </table>
        <div class="form-wrap-inner clearfix">
            <div class="form-group mt-4">
                <input type="submit" value="Search" class="btn btn-primary"/>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
