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
</head>
<body>
<div>
    <form action="/login" method="get">
        <input type="submit" value="Դուրս գալ համակարգից"/>
    </form>
</div>
<div class="doc-list">
    <table class="negrTable">
        <tbody>
        <tr>
            <td><a href="/createProductPage">Ստեղծել ապրանք</a></td>
        </tr>
        <tr>
            <td><a href="/searchProductPage">Փնտրել ապրանք</a></td>
        </tr>
        <tr>
            <td><a href="/createProductTypePage">Ավելացնել ապրանքի տեսակ</a></td>
        </tr>
        <tr>
            <td><a href="/updateProductTypePage">Թարմացնել ապրանքի տեսակ</a></td>
        </tr>
        <tr>
            <td><a href="/createUserPage">Ստեղծել օգտատեր</a></td>
        </tr>
        <tr>
            <td><a href="/updateUserPage">Թարմացնել օգտատերի տվյալները</a></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>