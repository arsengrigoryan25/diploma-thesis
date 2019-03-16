<%@taglib prefix="t" tagdir="/WEB-INF/tags/templates" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLang}"/>
<fmt:setBundle basename="text"/>
<t:mainTemplate>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/profile.js"></script>

    <div class="demo-content text-center">
        <div class="doc-tabs card card-direction-row justify-between">
            <h2 class="title marg0 pull-left"><fmt:message key="tpuser.search.label.userSearch"/></h2>
            <div class="tabs clearfix">
                <a href="/tc-app/user/registration-first" class="inline-link"><fmt:message key="tpuser.search.label.new"/></a>
            </div>
        </div>

        <div class="card">
            <div class="form-wrap clearfix">
                <form id="userSearch" action="${pageContext.request.contextPath}/user/search" method="GET" >
                    <div class="row">
                        <div class="form-group col-lg-4">
                            <label for="first_nameId"><fmt:message key="common.label.firstname"/></label>
                            <div class="input-group">
                                <input id="first_nameId" name="firstName" type="text" class="form-control"
                                       aria-label="Search for..." value="${tpUserFilterView.firstName}">
                            </div>
                        </div>
                        <div class="form-group col-lg-4">
                            <label for="last_nameId"><fmt:message key="common.label.lastname"/></label>
                            <div class="input-group">
                                <input id="last_nameId" name="lastName" type="text" class="form-control"
                                       aria-label="Search for..." value="${tpUserFilterView.lastName}">
                            </div>
                        </div>
                        <div class="form-group col-lg-4">
                            <label for="emailId"><fmt:message key="common.label.email"/></label>
                            <div class="input-group">
                                <input id="emailId" name="email" type="text" class="form-control"
                                       aria-label="Search for..." value="${tpUserFilterView.email}">
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-4">
                            <label for="emailId"><fmt:message key="tpuser.search.label.ssn"/></label>
                            <div class="input-group">
                                <input id="ssnId" name="ssn" type="text" class="form-control"
                                       aria-label="Search for..." value="${tpUserFilterView.ssn}">
                            </div>
                        </div>
                        <div class="form-group col-lg-4">
                            <label><fmt:message key="tpuser.search.label.dateFrom"/></label>
                            <input name="dateAfter" id="dateAfterId1" class="form-control" type="date"
                                   value="${tpUserFilterView.dateFrom}"/>
                        </div>
                        <div class="form-group col-lg-4">
                            <label><fmt:message key="tpuser.search.label.dateTo"/></label>
                            <input name="dateBefore" id="dateBeforeId1" class="form-control" type="date"
                                   value="${tpUserFilterView.dateTo}"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-lg-4">
                            <label for="sel1"><fmt:message key="tpuser.search.label.select"/></label>
                            <select class="form-control" id="sel1" name="userStatus" >
                                <option value=""  <c:if test="${tpUserFilterView.inited eq ' '}">selected="selected"</c:if>>
                                    <fmt:message key="tpuser.search.select.all"/></option>
                                <option value="1" <c:if test="${tpUserFilterView.inited eq '1'}">selected="selected"</c:if>>
                                    <fmt:message key="tpuser.search.select.active"/></option>
                                <option value="0" <c:if test="${tpUserFilterView.inited eq '0'}">selected="selected"</c:if>>
                                    <fmt:message key="tpuser.search.select.inactive"/></option>
                            </select>
                        </div>
                    </div>
                    <div class="form-wrap-inner mt-3 mb-4 clearfix">
                        <input type="submit" value="<fmt:message key="common.label.search"/>" class="btn btn-primary">
                        <input id="resetform" type="reset" value="<fmt:message key="common.label.reset"/>" class="btn btn-light "/>
                    </div>
                    <div class="doc-list">
                        <table class="negrTable">
                            <thead>
                            <tr>
                                <th><fmt:message key="common.label.firstname"/></th>
                                <th><fmt:message key="common.label.lastname"/></th>
                                <th><fmt:message key="common.label.email"/></th>
                                <th><fmt:message key="tpuser.search.label.ssn"/></th>
                                <th><fmt:message key="tpuser.search.label.documentType"/></th>
                                <th><fmt:message key="tpuser.search.label.documentNumber"/></th>
                                <th><fmt:message key="tpuser.search.label.registrationDate"/></th>
                                <th><fmt:message key="tpuser.search.label.select"/></th>
                                <th class="w80 text-center"><fmt:message key="tpuser.search.label.action"/></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${tpUsers}" var="user" varStatus="loop">
                                <tr>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td>${user.ssn}</td>
                                    <td>${msgFormat.getText(user.personDocumentType)}</td>
                                    <td>${user.docNumber}</td>
                                    <td>${user.createDate}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${user.inited == '1'}">
                                                <fmt:message key="tpuser.search.select.active"/>
                                            </c:when>
                                            <c:otherwise>
                                                <fmt:message key="tpuser.search.select.inactive"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td class="w80 text-center">
                                        <a href="${pageContext.request.contextPath}/user/edit-first?userId=${user.id}">
                                            <i class="fa fa-edit edit"></i>
                                        </a>
                                        <a href="#">
                                            <i class="fa fa-trash-o delete"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </div>
</t:mainTemplate>
<script>
    $(document).on("click","#resetform", function (e) {
        e.preventDefault();
        $("#userSearch input[type='text']").val("");
        $("#userSearch input[type='date']").val("");
        $('#sel1 option:nth-child(1)').attr("selected",true);
    })
</script>