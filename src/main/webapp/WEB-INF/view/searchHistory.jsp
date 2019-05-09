<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:c="http://java.sun.com/jstl/core"
      xmlns:a4j="http://richfaces.org/a4j"
      xmlns:rich="http://richfaces.org/rich"
      xmlns:f="http://java.sun.com/jsf/core"
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
            <div class="row negrTable table borderless">
                <div class="col-xs-3">
                    <div class="form-group">
                        <label>Ապրանքի շտրիխ կոդ</label>
                        <input type='text' class="form-control" name="barCode"/>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker1'>
                            <input type='text' class="form-control" name="startDate"/>
                            <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <div class='input-group date'>
                            <label>մինչև</label>
                        </div>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker2'>
                            <input type='text' class="form-control" name="endDate"/>
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


        <table class="negrTable table borderless">
            <thead>
            <tr>
                <th>1</th>
                <th>2</th>
                <th>3</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>I</td>
                <td>II</td>
                <td>III</td>
            </tr>
            </tbody>
        </table>
    </div>
</form:form>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker();
    });
    $(function () {
        $('#datetimepicker2').datetimepicker();
    });
</script>
</body>
</html>