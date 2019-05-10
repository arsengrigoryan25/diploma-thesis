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
<form:form action="${pageContext.request.contextPath}/searchProductByBarcode">
    <div class="doc-list">
        <a href="/">Գլխավոր էջ</a>
        <table class="negrTable">
            <tbody>
            <tr>
                <td><label>Շտրիխ կոդ</label></td>
                <td><input name="barcode" type="text" class="form-control" /></td>
            </tr>
            </tbody>
        </table>
        <div class="form-wrap-inner clearfix">
            <div class="form-group mt-4">
                <input type="submit" value="Ստուգել վաճառվող ապրանքը" class="btn btn-primary"/>
            </div>
        </div>
    </div>
    <label>${error}</label>
</form:form>
<form:form action="${pageContext.request.contextPath}/sellProduct">
    <div class="doc-list">
        <table class="negrTable">
            <tbody>
            <tr>
                <td><label>Ապրանքի անուն</label></td>
                <td><input id="nameId"  name="name" type="text" class="form-control" value="${productEntity.name}"/></td>
            </tr>
            <tr>
                <td><label>Տեսակ</label></td>
                <td><input id="typeId"  name="type" type="text" class="form-control" value="${productEntity.productTypeId}"/></td>
            </tr>
            <tr>
                <td><label>Վաճառքի գին</label></td>
                <td><input id="salePriceId" name="salePrice" type="text" class="form-control" value="${productEntity.salePrice}"/></td>
            </tr>
            <tr>
                <td><label>Շտրիխ կոդ</label></td>
                <td><input id="barcodeId" name="barcode" type="text" class="form-control" value="${productEntity.barcode}"/></td>
            </tr>
            <tr>
                <td><label>Քանակը</label></td>
                <td><input id="countId" name="count" type="text" class="form-control" ></td>
            </tr>
            </tbody>
        </table>

        <div class="form-wrap-inner clearfix">
            <div class="form-group mt-4">
                <input type="submit" value="Վաճառել ապրանք" class="btn btn-primary"/>
            </div>
        </div>
    </div>
    <label>${error}</label>
</form:form>
</body>
</html>
