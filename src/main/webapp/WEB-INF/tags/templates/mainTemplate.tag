<%@taglib prefix="t" tagdir="/WEB-INF/tags/templates" %>
<%@tag description="Main tp-app template" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLang}"/>
<fmt:setBundle basename="text"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Kyrgyz demo</title>
    <!-- Site favicon -->
    <link rel='shortcut icon' type='image/x-icon' href='${pageContext.servletContext.contextPath}/assets/images/tc-ico.png'/>
    <!-- /site favicon -->
    <!-- Font Material stylesheet -->
    <link rel="stylesheet"
          href="${pageContext.servletContext.contextPath}/assets/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <!-- /font material stylesheet -->
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/assets/fonts/fontawesome/css/font-awesome.css">
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
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,900|Open+Sans:300,400,600,700&amp;subset=cyrillic-ext" rel="stylesheet">
    <!-- Modernizer -->
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/vendor/modernizr.custom.js"></script>

</head>

<body id="body" data-theme="dark-indigo">

<!-- Page container -->
<div class="gx-container">

    <!-- Main Container -->
    <div class="gx-main-container">

        <!-- Main Header -->
        <header class="main-header">
            <t:dashboardTopbar/>
            <!-- Sidebar -->
            <t:dashboardSidebar/>
        </header>
        <!-- /main header -->
        <!-- Main Content -->
        <div class="gx-main-content">
            <!--gx-wrapper-->
            <div class="gx-wrapper ht">
                <div class="container ht">
                    <jsp:doBody/>
                </div>
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
<script>
    if ($(".nav-bar-exist").length > 0) {
        $(".gx-main-content").addClass("loggedin");
    }
</script>
</body>
</html>