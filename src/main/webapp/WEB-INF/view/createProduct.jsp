<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form:form action="${pageContext.request.contextPath}/createProduct">
    <div class="doc-list">
        <a href="/">Գլխավոր էջ</a>
        <table class="negrTable">
            <tbody>
            <tr>
                <td><label>Ապրանքի անուն</label></td>
                <td><input id="nameId"  name="name" type="text" class="form-control" value="${productEntity.name}"/></td>
            </tr>
            <tr>
                <td><label>Տեսակ</label></td>
                <td><select id="productTypeId" name="productType" class="form-control">
                    <c:forEach items="${productType}" var="type">
                        <option value="${type.id}" <c:if test="${productEntity.productTypeId eq type.id}"> selected="selected" </c:if>>
                                ${type.name}
                        </option>
                    </c:forEach>
                </select></td>
            </tr>
            <tr>
                <td><label>Նկարագրությունը</label></td>
                <td><input id="descriptionId" name="description" type="text" class="form-control" value="${productEntity.description}"/></td>
            </tr>
            <tr>
                <td><label>Քանակը</label></td>
                <td><input id="countId" name="countInWarehouse" type="text" class="form-control" value="${productEntity.countInWarehouse}"></td>
            </tr>
            <tr>
                <td><label>Գնման գին</label></td>
                <td><input id="purchasePriceId" name="purchasePrice" type="text" class="form-control" value="${productEntity.purchasePrice}"/></td>
            </tr>
            <tr>
                <td><label>Վաճառքի գին</label></td>
                <td><input id="salePriceId" name="salePrice" type="text" class="form-control" value="${productEntity.salePrice}"/></td>
            </tr>
            <tr>
                <td><label>Ապրանքի կոդը</label></td>
                <td><input id="productCodeId" name="productCode" type="text" class="form-control" value="${productEntity.productCode}"/></td>
            </tr>
            <tr>
                <td><label>Շտրիխ կոդ</label></td>
                <td><input id="barCodeId" name="barcode" type="text" class="form-control" /></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
            </tbody>
            <label>${error}</label>
        </table>

        <div class="form-wrap-inner clearfix">
            <div class="form-group mt-4">
                <input type="submit" value="Ավելացնել ապրանք" class="btn btn-primary"/>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
