<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 11/17/2017
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Admin page</title>
    <%--<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="../../resources/css/bootstrap-theme.min.css">--%>
    <script src="../../resources/js/jquery-3.2.1.js"></script>
</head>
<body>

    <jsp:include page="../block/sitenavbar.jsp"/>

    <div class="alert alert-info">
        <h2 class="text-center">${locale_admin_table_header} <span class="glyphicon glyphicon-tags"></span></h2>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-striped text-center">
                    <thead>
                    <tr>
                        <th class="text-center">${locale_admin_table_hotelname}</th>
                        <th class="text-center">${locale_admin_table_hotelcount}</th>
                        <th class="text-center">${locale_admin_table_deleteform}</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${hotelList}" var="item">
                            <tr>
                                <td>${item.name}</td>
                                <td>${item.placesCount}</td>
                                <td>
                                    <form action="/hotelsminsk">
                                        <input type="text" name="hotelid" value="${item.id}" hidden="hidden"/>
                                        <input type="text" name="command" value="deletehotel" hidden="hidden"/>
                                        <button type="submit" class="btn btn-danger">${locale_admin_table_btndelete} <span class="glyphicon glyphicon-remove"></span> </button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <br/>
    <hr/>
    <div class="container">
            <h3 class="text-center" style="text-decoration: underline;">${locale_admin_registration_header}</h3>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form action="/hotelsminsk">
                    <div class="form-group">
                        <label>${locale_admin_registration_label_hotelname}:</label>
                        <input type="text" name="hotelname" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label>${locale_admin_registration_label_hotelcount}:</label>
                        <input type="text" name="placescount" class="form-control"/>
                    </div>
                    <input type="text" name="command" value="addhotel" hidden="hidden"/>
                    <button type="submit" class="btn btn-success btn-block">${locale_admin_registration_btnadd} <span class="glyphicon glyphicon-plus"></span> </button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
