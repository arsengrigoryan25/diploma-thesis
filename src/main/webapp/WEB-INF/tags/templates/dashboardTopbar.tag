<%@tag description=" " pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLang}" />
<fmt:setBundle basename="text" />

<div class="gx-toolbar">
    <div class="container">

    <div class="d-flex justify-content-start align-items-center pull-left w-50" >
        <a class="site-logo" href="${pageContext.servletContext.contextPath}/">
            <img src="${pageContext.servletContext.contextPath}/assets/images/kyrgyzstan_logo.png" alt="kyrgyzstan" title="kyrgyzstan">
        </a>

        <div class="site-title">
            <h1><fmt:message key="app.top.title"/></h1>
            <p class="sub-title"><fmt:message key="app.top.subtitle"/></p>
        </div>
    </div>

    <!--UserDTO photo-->
    <div class="d-flex justify-content-end align-items-center right-menu pull-right w-50">

        <c:set var="paramList" value="" scope="request"/>
        <c:if test="${not empty param}">
            <c:forEach items="${param.keySet()}" var="key">
                <c:if test="${key != 'setLanguage'}">
                    <c:set var="paramList" value="${paramList}${key}=${param.get(key)}&"/>
                </c:if>
            </c:forEach>
        </c:if>
        <c:set var="paramList" value="?${paramList}setLanguage="/>

        <div id="languages" class="language dropdown">
            <a href="#" class="dropdown-toggle active-lang" href="#" role="button" id="language"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">${userLang.toUpperCase()}</a>
            <ul class="dropdown-menu language-list" aria-labelledby="language" x-placement="bottom-end" style="display: none">
                <c:forEach items="${sessionScope.langList}" var="ln">
                    <li class="dropdown-item">
                        <a href="${paramList}${ln.code}">${msgFormat.getText(ln, ln.code)}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="ml-2 ml-xl-3 my-sm-0 mr-0" id="username">${tcSessionContext.user.username}</div>

        <div class="dropdown" id="user-profile" >
                <a class="dropdown-toggle no-arrow d-inline-block ml-2 user-photo" href="#" role="button" id="userInfo"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="zmdi zmdi-account text-grey zmdi-hc-fw user-blank"></i>
                </a>

                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userInfo" x-placement="bottom-end" style="display: none;">
                    <a class="dropdown-item" href="${pageContext.servletContext.contextPath}/logout" id="logout">
                        <i class="zmdi zmdi-sign-in zmdi-hc-fw mr-2"></i>
                        <fmt:message key="app.top.user.logout"/>
                    </a>
                </div>
         </div>

        <!--login link-->
        <a href="" class="text-white ml-2 ml-xl-3 my-sm-0 mr-0" style="display:none" id="login"> <fmt:message key="login.button.submit"/></a>
    </div>
    <!-- END Top-bar -->
    </div>
</div>
