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
    <link rel="stylesheet" href="../../css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-offset-3 col-xs-6">
            <br/>
            <div>
                <form action="/login" method="get">
                    <button type="submit" class="btn btn-md btn-info">Դուրս գալ համակարգից</button>
                </form>
            </div>
            <hr>
            <div class="doc-list">
                <div class="negrTable">
                    <ul>
                        <li>
                            <a href="/sellProductPage">Վաճառել ապրանք</a>
                        </li>
                        <li>
                            <a href="/createProductPage">Ստեղծել ապրանք</a>
                        </li>
                        <li>
                            <a href="/searchOrAddProductPage">Փնտրել կամ ավելացնել ապրանք</a>
                        </li>
                        <li>
                            <a href="/createProductTypePage">Ավելացնել ապրանքի տեսակ</a>
                        </li>
                        <li>
                            <a href="/updateProductTypePage">Թարմացնել ապրանքի տեսակ</a>
                        </li>
                        <li>
                            <a href="/createUserPage">Ստեղծել օգտատեր</a>
                        </li>
                        <li>
                            <a href="/updateUserPage">Թարմացնել օգտատերի տվյալները</a>
                        </li>
                        <li>
                            <a href="/searchHistoryPage">Ապրանքների շարժի մատյան</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>