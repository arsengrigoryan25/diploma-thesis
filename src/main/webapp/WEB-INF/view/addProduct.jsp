<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:a="http://www.custom.com/jsf/facelets"
      xmlns:a4j="http://richfaces.org/a4j"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:a4j="http://richfaces.org/a4j"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:c="http://java.sun.com/jstl/core"
      xmlns:rich="http://richfaces.org/rich">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form action="${pageContext.request.contextPath}/addProduct">
    <div class="doc-list">
        <table class="negrTable">
            <tbody>
            <tr>
                <td>Քանակը</td>
                <td><input id="countId" name="count" type="text" class="form-control"></td>
            </tr>
            <tr>
                <td>Ապրանքի կոդը</td>
                <td><input id="productCodeId" name="productCode" type="text" class="form-control"/></td>
            </tr>
            <tr>
                <td>Շտրիխ կոդ<</td>
                <td><input id="barCodeId" name="barcode" type="text" class="form-control"/></td>
            </tr>
            <tr>
                <td>Ապրանքը ավելացնել</td>
                <td>
                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="addProductStatus" value="true" checked>
                        <label class="custom-control-label" for="defaultGroupExample1">Պահեստ</label>
                    </div>

                    <div class="custom-control custom-radio">
                        <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="addProductStatus" value="False" >
                        <label class="custom-control-label" for="defaultGroupExample2">Խանութ</label>
                    </div>
                </td>
            </tr>
            </tbody>
            <label>${error}</label>
        </table>
        <div class="form-wrap-inner clearfix">
            <div class="form-group mt-4">
                <input type="submit" value="Search" class="btn btn-primary">
            </div>
        </div>
    </div>
</form:form>
</body>
</html>