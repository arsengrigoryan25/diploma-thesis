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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-offset-3 col-xs-6">
            <form:form action="${pageContext.request.contextPath}/createProduct">
                <div class="doc-list">
                    <h2>Ստեղծել ապրանք</h2>
                    <a href="/">Գլխավոր էջ</a>
                    <hr>
                    <div class="negrTable">
                        <ul class="list-unstyled text-left">
                            <li>
                                <label>Ապրանքի անուն</label>
                                <input id="nameId"  name="name" type="text" class="form-control" value="${productEntity.name}"/>
                            </li>
                            <li>
                                <label>Տեսակ</label>
                                <select id="productTypeId" name="productType" class="form-control">
                                    <c:forEach items="${productType}" var="type">
                                        <option value="${type.id}" <c:if test="${productEntity.productTypeId eq type.id}"> selected="selected" </c:if>>
                                                ${type.name}
                                        </option>
                                    </c:forEach>
                                </select>
                            </li>
                            <li>
                                <label>Նկարագրությունը</label>
                                <input id="descriptionId" name="description" type="text" class="form-control" value="${productEntity.description}"/>
                            </li>
                            <li>
                                <label>Քանակը</label>
                                <input id="countId" name="countInWarehouse" type="text" class="form-control" value="${productEntity.countInWarehouse}">
                            </li>
                            <li>
                                <label>Գնման գին</label>
                                <input id="purchasePriceId" name="purchasePrice" type="text" class="form-control" value="${productEntity.purchasePrice}"/>
                            </li>
                            <li>
                                <label>Վաճառքի գին</label>
                                <input id="salePriceId" name="salePrice" type="text" class="form-control" value="${productEntity.salePrice}"/>
                            </li>
                            <li>
                                <label>Ապրանքի կոդը</label>
                                <input id="productCodeId" name="productCode" type="text" class="form-control" value="${productEntity.productCode}"/>
                            </li>
                            <li>
                                <label>Շտրիխ կոդ</label>
                                <input id="barCodeId" name="barcode" type="text" class="form-control" />
                            </li>

                        </ul>
                    </div>

                    <div class="form-wrap-inner clearfix">
                        <div class="form-group mt-4">
                            <input type="submit" value="Ավելացնել ապրանք" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
                <label>${error}</label>
            </form:form>
        </div>
    </div>
</div>

</body>
</html>
