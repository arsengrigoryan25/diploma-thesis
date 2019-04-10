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
        <a href="/">Main page</a>
        <div class="row">
            <div class="form-group col-xs-12 col-lg-4">
                <label> Ապրանքի անուն</label>
                <input id="nameId"  name="name" type="text" class="form-control" value="${productEntity.name}"/>
            </div>
            <div class="form-group col-xs-12 col-lg-4">
                <label>Տեսակ</label>
                <select id="productTypeId" name="productType" class="form-control">
                    <c:forEach items="${productType}" var="type">
                        <option value="${type.id}" <c:if test="${productEntity.typeId eq type.id}"> selected="selected" </c:if>>
                                ${type.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-xs-12 col-lg-4">
                <label>Նկարագրությունը</label>
                <input id="descriptionId" name="description" type="text" class="form-control" value="${productEntity.description}"/>
            </div>
            <div class="form-group col-xs-12 col-lg-4">
                <label>Քանակը</label>
                <input id="countId" name="countInWarehouse" type="text" class="form-control" value="${productEntity.countInWarehouse}">
            </div>
            <div class="form-group col-xs-12 col-lg-4">
                <label>Գնման գին</label>
                <input id="purchasePriceId" name="purchasePrice" type="text" class="form-control" value="${productEntity.purchasePrice}"/>
            </div>
            <div class="form-group col-xs-12 col-lg-4">
                <label>Վաճառքի գին</label>
                <input id="salePriceId" name="salePrice" type="text" class="form-control" value="${productEntity.salePrice}"/>
            </div>
            <div class="form-group col-xs-12 col-lg-4">
                <label>Ապրանքի կոդը</label>
                <input id="productCodeId" name="productCode" type="text" class="form-control" value="${productEntity.productCode}"/>
            </div>
            <div class="form-group col-xs-12 col-lg-4">
                <label>Շտրիխ կոդ</label>
                <input id="barCodeId" name="barcode" type="text" class="form-control" />
                <label>${error}</label>
            </div>

        </div>
        <div class="form-wrap-inner clearfix">
            <div class="form-group mt-4">
                <input type="submit" value="Search" class="btn btn-primary"/>
            </div>
        </div>
    </div>
</form:form>
</body>
</html>
