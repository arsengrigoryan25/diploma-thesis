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

    <link rel="stylesheet" type="text/css" media="screen" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <link href="./css/prettify-1.0.css" rel="stylesheet">
    <link href="./css/base.css" rel="stylesheet">
    <link href="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/build/css/bootstrap-datetimepicker.css"
          rel="stylesheet">
    <link rel="stylesheet" href="../../css/style.css">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="//code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.9.0/moment-with-locales.js"></script>


    <script src="//cdn.rawgit.com/Eonasdan/bootstrap-datetimepicker/e8bddc60e73c1ec2475f827be36e1957af72e2ea/src/js/bootstrap-datetimepicker.js"></script>

</head>
<body>

<form:form action="${pageContext.request.contextPath}/searchHistory">
    <div class="doc-list">
        <a href="/">Գլխավոր էջ</a>
        <div class="container">

            <div class="col-xs-3">
                <div class="form-group">
                    <label>Ապրանքի շտրիխ կոդ</label>
                    <input type='text' class="form-control" name="barcode" value="${filterValue.barcode}"/>
                </div>
            </div>

            <div class="col-xs-3">
                <div class="form-group">
                    <label>Ապրանքի կարգավիճակը</label>
                    <select id="productTypeId" name="productState" class="form-control">
                        <c:forEach items="${productState}" var="state">
                            <option value="${state.id}"
                            <c:if test="${filterValue.productState eq state.id}"> selected="selected" </c:if>>
                                ${state.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class='col-sm-3'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker'>
                            <input type='text' class="form-control" name="startDate" value="${filterValue.startDate}"/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class='col-sm-3'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker1'>
                            <input type='text' class="form-control" name="endDate" value="${filterValue.endDate}"/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                        </div>
                    </div>
                </div>
            </div>


            <div class="form-wrap-inner clearfix">
                <div class="form-group mt-4">
                    <input type="submit" value="Փնտրել" class="btn btn-primary">
                </div>
            </div>

            <label>${error}</label>
        </div>
        <div class="container-fluid">
            <table class="negrTable" style="overflow: auto;    margin: 0 auto;">
                <thead>
                <tr>
                    <th>Հ/Հ</th>
                    <th>Անուն</th>
                    <th>Շտրիխ կոդ</th>
                    <th>Ապրանքի կոդ</th>
                    <th>Ամսաթիվ</th>
                    <th>Ավելացվել է</th>
                    <th>Փոփոխությունը պահեստում</th>
                    <th>Փոփոխությունը խանութում</th>
                    <th>Վաճառված ապրանքը</th>
                    <th>Քանակ</th>
                    <th>Գործողության նկարագրում</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${searchInfo}" var="info">
                    <tr>
                        <td>${info.id}</td>
                        <td>${info.name}</td>
                        <td>${info.barcode}</td>
                        <td>${info.productCode}</td>
                        <td>${info.changeDate}</td>
                        <td>${info.incrementOrDecrement}</td>
                        <td>${info.addProductInWarehouse}</td>
                        <td>${info.addProductInShop}</td>
                        <td>${info.sell}</td>
                        <td>${info.count}</td>
                        <td>${info.info}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</form:form>
<script type="text/javascript">
    // $(function () {
    //     $('#datetimepicker1').datetimepicker();
    // });
    // $(function () {
    //     $('#datetimepicker2').datetimepicker();
    // });
    // $(function() {
    //     $('#datetimepicker4').datetimepicker({
    //         pickTime: false
    //     });
    // });
    // ---------------------------------------------------------------------------------
    //     Date formats: yyyy-mm-dd, yyyymmdd, dd-mm-yyyy, dd/mm/yyyy, ddmmyyyyy

    $(function () {
        var bindDatePicker = function () {
            $(".date").datetimepicker({
                format: 'YYYY-MM-DD',
                icons: {
                    time: "fa fa-clock-o",
                    date: "fa fa-calendar",
                    up: "fa fa-arrow-up",
                    down: "fa fa-arrow-down"
                }
            }).find('input:first').on("blur", function () {
                // check if the date is correct. We can accept dd-mm-yyyy and yyyy-mm-dd.
                // update the format if it's yyyy-mm-dd
                var date = parseDate($(this).val());

                if (!isValidDate(date)) {
                    //create date based on momentjs (we have that)
                    date = moment().format('YYYY-MM-DD');
                }

                $(this).val(date);
            });
        }

        var isValidDate = function (value, format) {
            format = format || false;
            // lets parse the date to the best of our knowledge
            if (format) {
                value = parseDate(value);
            }

            var timestamp = Date.parse(value);

            return isNaN(timestamp) == false;
        }

        var parseDate = function (value) {
            var m = value.match(/^(\d{1,2})(\/|-)?(\d{1,2})(\/|-)?(\d{4})$/);
            if (m)
                value = m[5] + '-' + ("00" + m[3]).slice(-2) + '-' + ("00" + m[1]).slice(-2);

            return value;
        }

        bindDatePicker();
    });

    $(function () {
        var bindDatePicker1 = function () {
            $(".date").datetimepicker({
                format: 'dd-mm-yyyy',
                icons: {
                    time: "fa fa-clock-o",
                    date: "fa fa-calendar",
                    up: "fa fa-arrow-up",
                    down: "fa fa-arrow-down"
                }
            }).find('input:first').on("blur", function () {
                // check if the date is correct. We can accept dd-mm-yyyy and yyyy-mm-dd.
                // update the format if it's yyyy-mm-dd
                var date = parseDate($(this).val());

                if (!isValidDate(date)) {
                    //create date based on momentjs (we have that)
                    date = moment().format('YYYY-MM-DD');
                }

                $(this).val(date);
            });
        }

        var isValidDate = function (value, format) {
            format = format || false;
            // lets parse the date to the best of our knowledge
            if (format) {
                value = parseDate(value);
            }

            var timestamp = Date.parse(value);

            return isNaN(timestamp) == false;
        }

        var parseDate = function (value) {
            var m = value.match(/^(\d{1,2})(\/|-)?(\d{1,2})(\/|-)?(\d{4})$/);
            if (m)
                value = m[5] + '-' + ("00" + m[3]).slice(-2) + '-' + ("00" + m[1]).slice(-2);

            return value;
        }

        bindDatePicker1();
    });
</script>
</body>
</html>