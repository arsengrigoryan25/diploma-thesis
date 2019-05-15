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
<div class="container text-center">
    <form:form action="${pageContext.request.contextPath}/searchProductByBarcode">
        <div class="row">
            <div class="col-xs-offset-3 col-xs-6">
                <div class="doc-list">
                    <h2>Վաճառել ապրանք</h2>
                    <a href="/">Գլխավոր էջ</a>
                    <hr>
                    <div class="negrTable">
                        <div class="text-left form-group">
                            <label for="sh-code" >Շտրիխ կոդ</label>
                            <input name="barcode" id="sh-code" type="text" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-wrap-inner text-right">
                        <div class="form-group mt-4">
                            <button type="submit" class="btn btn-primary">Ստուգել վաճառվող ապրանքը</button>
                        </div>
                    </div>
                </div>
                <label>${error}</label>
            </div>
        </div>

    </form:form>
    <form:form action="${pageContext.request.contextPath}/sellProduct">
        <div class="doc-list row">
            <div class=" col-xs-offset-3 col-xs-6">
                <div class="negrTable">
                    <ul class="list-unstyled text-left">
                        <li>
                            <label>Ապրանքի անուն</label>
                            <input id="nameId"  name="name" type="text" class="form-control" value="${productEntity.name}" readonly/>
                        </li>
                        <li>
                            <label>Տեսակ</label>
                            <input id="typeId"  name="type" type="text" class="form-control" value="${productEntity.productTypeId}" readonly/>
                        </li>
                        <li>
                            <label>Վաճառքի գին</label>
                            <input id="salePriceId" name="salePrice" type="text" class="form-control" value="${productEntity.salePrice}" readonly/>
                        </li>
                        <li>
                            <label>Շտրիխ կոդ</label>
                            <input id="barcodeId" name="barcode" type="text" class="form-control" value="${productEntity.barcode}" readonly/>
                        </li>
                        <li>
                            <label>Քանակը</label>
                            <input id="countId" name="count" type="text" class="form-control" >
                        </li>
                    </ul>
                </div>

                <div class="form-wrap-inner clearfix">
                    <div class="form-group mt-4">
                        <input type="submit" value="Վաճառել ապրանք" class="btn btn-primary"/>
                    </div>
                </div>
            </div>

        </div>
        <label>${error}</label>
    </form:form>
</div>

</body>
</html>
