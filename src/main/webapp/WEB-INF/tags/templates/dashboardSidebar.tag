<%@tag description=" " pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Sidebar -->
<div id="menu" class="side-nav gx-sidebar nav-bar-exist">
    <div class="navbar-expand-lg">
        <div class="container">
                <!-- Main navigation -->
                <div id="main-menu" class="main-menu">
                    <ul class="nav-menu">
                        <c:forEach items="${tcMenu.subItems}" var="menuItem">
                            <c:if test="${menuItem.published && (menuItem.id != 11 || menuItem.id == 11 && tcSessionContext.role == 'ADMIN')}">
                                <li class="menu">
                                    <a href="<c:choose><c:when test="${menuItem.urlMapping != null}">${pageContext.request.contextPath}${menuItem.urlMapping}</c:when><c:otherwise>javascript:void(0)</c:otherwise></c:choose>"
                                       class="top-lv <c:if test='${empty menuItem.subItems}'> without</c:if>">
                                        <span class="nav-text">${menuItem.getName(userLang)}</span></a>
                                    <c:if test='${not empty menuItem.subItems}'>
                                        <ul class="sub-menu">
                                            <c:forEach items="${menuItem.subItems}" var="subItem">
                                                <c:if test="${subItem.published}">
                                                    <li class="<c:choose><c:when test='${menuItem.published}'>published</c:when><c:otherwise>unpublished</c:otherwise></c:choose>">
                                                        <c:choose>
                                                            <c:when test="${subItem.urlMapping.startsWith('http')}">
                                                                <a href="${subItem.urlMapping}" class="sub-mn">
                                                                    <span class="nav-text">${subItem.getName(userLang)}</span></a>
                                                            </c:when>
                                                            <c:otherwise><a href="${pageContext.request.contextPath}${subItem.urlMapping}">
                                                                <span class="nav-text">${subItem.getName(userLang)}</span></a></c:otherwise>
                                                        </c:choose>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </c:if>
                                </li>
                            </c:if>
                        </c:forEach>
                   </ul>
                </div>
                <!-- /main navigation -->
        </div>
    </div>
</div>
<!-- /page sidebar -->