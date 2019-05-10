<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jstl/core"
>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/searchProduct">
    <div class="doc-list">
        <a href="/">Գլխավոր էջ</a>
        <table class="negrTable">
            <tbody>
            <tr>
                <td><label>Ապրանքի անուն</label></td>
                <td><input id="nameId" name="name" type="text" class="form-control" value="${filterValue.name}"/></td>
            </tr>
            <tr>
                <td><label>Տեսակ</label></td>
                <td>
                    <select id="productTypeId" name="productType" class="form-control">
                        <c:forEach items="${productType}" var="type">
                            <option value="${type.id}"
                            <c:if test="${filterValue.productTypeId eq type.id}"> selected="selected" </c:if>>
                                ${type.name}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Ապրանքի կոդը</label></td>
                <td><input id="productCodeId" name="productCode" type="text" class="form-control" value="${filterValue.productCode}"/></td>
            </tr>
            <tr>
                <td><label>Շտրիխ կոդ</label></td>
                <td><input id="barcodeId" name="barcode" type="text" class="form-control" value="${filterValue.barcode}"/></td>
            </tr>
            </tbody>
            <label>${error}</label>
        </table>
        <div class="form-wrap-inner clearfix">
            <div class="form-group mt-4">
                <input type="submit" value="Փնտրել" class="btn btn-primary">
            </div>
        </div>

        <div class="doc-list">
            <table class="negrTable table borderless">
                <thead>
                <tr>
                    <th> Համար</th>
                    <th> Ապրանքի անուն</th>
                    <th> Տեսակ</th>
                    <th> Նկարագրությունը</th>
                    <th> Ապրանքի քանակը պահեստում</th>
                    <th> Ապրանքի քանակը խանութում</th>
                    <th> Գնման գին</th>
                    <th> Վաճառքի գին</th>
                    <th> Ապրանքի կոդը</th>
                    <th> Շտրիխ կոդ</th>
                    <th> Գործողություն</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productDTOList}" var="product" varStatus="loop">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.productType}</td>
                        <td>${product.description}</td>
                        <td>${product.countInWarehouse}</td>
                        <td>${product.countInShop}</td>
                        <td>${product.purchasePrice}</td>
                        <td>${product.salePrice}</td>
                        <td class="current-product-code">${product.productCode}</td>
                        <td class="current-bar-code">${product.barcode}</td>

                        <td class="w80 text-center">
                            <button type="button" class="btn btn-info btn-lg open-modal" data-toggle="modal" data-target="#myModal">
                                Ավելացնել ապրանք
                            </button>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/deleteProduct/${product.barcode}"
                               onclick="return confirm('Դուք ուզում եք ջնջել տվյալ ապրանքը');"
                               class="btn btn-info btn-lg">Ջնջել ապրանք</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</form:form>
<form:form action="${pageContext.request.contextPath}/addProduct">
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">

                    <input id="barcode-id" name="barcode" type="hidden" value="">
                    <input id="productcode-id" name="productCode" type="hidden" value="">

                    <table class="negrTable">
                        <tbody>
                        <tr>
                            <td>Քանակը</td>
                            <td><input id="countId" name="count" type="text" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>Ապրանքը ավելացնել</td>
                            <td>
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="addProductStatus" value="true"
                                           checked>
                                    <label class="custom-control-label" for="defaultGroupExample1">Պահեստ</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" class="custom-control-input" id="defaultGroupExample2" name="addProductStatus" value="False">
                                    <label class="custom-control-label" for="defaultGroupExample2">Խանութ</label>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                        <label>${error}</label>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary ajax">Ավելացնել</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Փակել</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
<script>
    $(document).on('click', ".open-modal", function () {
        var text = $(this).closest('tr').find('.current-bar-code').text();
        var text1 = $(this).closest('tr').find('.current-product-code').text();
        $("#barcode-id").val(text);
        $("#productcode-id").val(text);
    });
    $(document).on('click', ".btn", function (e) {
        if ($(this).hasClass('ajax')) {
            e.preventDefault();
            var form = $(this).closest('form');
            var data = form.serialize();
            var action = form.attr('action');
            var method = form.attr('method');
            console.log(data, action, method);
            $.ajax({
                url: action,
                type: method,
                data: data,
                success: function (response) {
                    console.log(response)
                    window.location.reload();
                }
            })
        }
    });
</script>
</body>
</html>