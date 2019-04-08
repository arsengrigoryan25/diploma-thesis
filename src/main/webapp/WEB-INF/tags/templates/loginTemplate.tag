<%@tag description="Main tp-app template" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLang}" />
<fmt:setBundle basename="text" />

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Kyrgyz demo</title>
    <!-- Site favicon -->
    <link rel='shortcut icon' type='image/x-icon' href='${pageContext.servletContext.contextPath}/assets/images/tc-ico.png' />
    <!-- /site favicon -->
    <!-- Font Material stylesheet -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <!-- /font material stylesheet -->
    <!-- Bootstrap stylesheet -->
    <link href="${pageContext.servletContext.contextPath}/assets/css/jumbo-bootstrap.css" rel="stylesheet">
    <!-- /bootstrap stylesheet -->
    <!-- Perfect Scrollbar stylesheet -->
    <link href="${pageContext.servletContext.contextPath}/assets/node_modules/perfect-scrollbar/css/perfect-scrollbar.css" rel="stylesheet">
    <!-- /perfect scrollbar stylesheet -->
    <!-- Jumbo-core stylesheet -->
    <link href="${pageContext.servletContext.contextPath}/assets/css/jumbo-core.css" rel="stylesheet">
    <!-- /jumbo-core stylesheet -->
    <!-- Color-Theme stylesheet -->
    <link id="override-css-id" href="${pageContext.servletContext.contextPath}/assets/css/theme-dark-indigo.css" rel="stylesheet">
    <!-- Color-Theme stylesheet -->
    <script src="${pageContext.servletContext.contextPath}/assets/node_modules/jquery/dist/jquery.min.js"></script>
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900|Open+Sans:300,400,600,700&amp;subset=cyrillic-ext" rel="stylesheet">

</head>

<body id="body" data-theme="dark-indigo">

<!-- Loader Backdrop -->
<div class="loader-backdrop">
    <!-- Loader -->
    <div class="loader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10"></circle>
        </svg>
    </div>
    <!-- /loader-->
</div>
<!-- loader backdrop -->

<!-- Page container -->
<div class="gx-container">

    <!-- Main Container -->
    <div class="gx-main-container">

        <!-- Main Header -->
        <header class="main-header">
            <div class="gx-toolbar">
                <div class="container">
                <div>
                    <div class="sidebar-mobile-menu d-block d-lg-none">
                        <a class="gx-menu-icon menu-toggle" href="#menu">
                            <span class="menu-icon"></span>
                        </a>
                    </div>
                    <a class="site-logo pull-left" href="${pageContext.servletContext.contextPath}/">
                    <img src="${pageContext.servletContext.contextPath}/assets/images/kyrgyzstan_logo.png" alt="kyrgyzstan" title="kyrgyzstan">
                    </a>
                    <div class="site-title pull-left">
                        <h1><fmt:message key="app.top.title"/></h1>
                        <p class="sub-title"><fmt:message key="app.top.subtitle"/></p>
                    </div>
                </div>

                <c:set var="paramList" value="" scope="request"/>
                <c:if test="${not empty param}">
                    <c:forEach items="${param.keySet()}" var="key">
                        <c:if test="${key != 'setLanguage'}">
                            <c:set var="paramList" value="${paramList}${key}=${param.get(key)}&"/>
                        </c:if>
                    </c:forEach>
                </c:if>
                <c:set var="paramList" value="?${paramList}setLanguage="/>

                <div class="d-flex justify-content-end right-menu ">
                    <div id="languages" class="language dropdown pull-right" style="z-index: 9999">
                        <a href="#" class="dropdown-toggle active-lang" href="#" role="button" id="language"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${userLang.toUpperCase()}</a>
                        <ul class="dropdown-menu language-list" aria-labelledby="language" x-placement="bottom-end" style="display: none">
                            <c:forEach items="${sessionScope.langList}" var="ln">
                                <li class="dropdown-item"><a href="${paramList}${ln.code}">${msgFormat.getText(ln, ln.code)}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                </div>
            </div>
        </header>
        <!-- /main header -->


        <!-- Main Content -->
        <div class="gx-main-content">
            <!--gx-wrapper-->
            <div class="gx-wrapper">
                <jsp:doBody />
            </div>
            <!--/gx-wrapper-->
            <!-- Footer -->
            <footer class="gx-footer">
                <div class="d-flex flex-row justify-content-between">
                    <p><fmt:message key="app.footer.developed_by"/></p>
                    <a href="https://iunetworks.am/" target="_blank" class="btn-link text-uppercase">IU Networks</a>
                </div>
            </footer>
            <!-- /footer -->

        </div>
        <!-- /main content -->

    </div>
    <!-- /main container -->

</div>
<!-- /page container -->

<!-- Menu Backdrop -->
<div class="menu-backdrop fade"></div>
<!-- /menu backdrop -->
<!--Load JQuery-->

<!--Bootstrap JQuery-->
<script src="${pageContext.servletContext.contextPath}/assets/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!--Perfect Scrollbar JQuery-->
<script src="${pageContext.servletContext.contextPath}/assets/node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
<!--Big Slide JQuery-->
<script src="${pageContext.servletContext.contextPath}/assets/node_modules/bigslide/dist/bigSlide.min.js"></script>

<!--Custom JQuery-->
<script src="${pageContext.servletContext.contextPath}/assets/js/functions.js?v=1.0.3"></script>

</body>
</html>