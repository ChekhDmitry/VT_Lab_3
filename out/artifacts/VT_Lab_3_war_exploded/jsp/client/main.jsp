
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 11/17/2017
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client page</title>
    <%--<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="../../resources/css/bootstrap-theme.min.css">--%>
    <script src="../../resources/js/jquery-3.2.1.js"></script>
</head>
<body>

    <jsp:include page="../block/sitenavbar.jsp"/>
    <div class="alert alert-info">
        <h2 class="text-center">${locale_client_table_header} <span class="glyphicon glyphicon-tags"></span></h2>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-striped text-center">
                    <thead>
                        <tr>
                            <th class="text-center">${locale_client_table_hotelname}</th>
                            <th class="text-center">${locale_client_table_hotelcount}</th>
                            <th class="text-center">${locale_client_table_reservationform}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${hotelList}" var="item">
                            <tr>
                                <td>${item.name}</td>
                                <td>${item.placesCount}</td>
                                <td>
                                    <form action="/hotelsminsk" class="form-inline">
                                        <input type="text" name="hotelid" value="${item.id}" hidden="hidden"/>
                                        <input type="text" name="reservedplacescount" class="form-control"/>
                                        <input type="text" name="command" hidden="hidden" value="reservehotel"/>
                                        <button type="submit" class="btn btn-primary">${locale_client_table_btnreserve} <span class="glyphicon glyphicon-tag"></span> </button>
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
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="alert alert-warning">
                    <h3 class="text-center">${locale_client_reservedtabel_header} <span class="glyphicon glyphicon-list"></span></h3>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <table class="table table-striped text-center">
                    <thead>
                        <tr>
                            <th class="text-center">${locale_client_reservedtabel_hotelname}</th>
                            <th class="text-center">${locale_client_reservedtabel_hotelcount}</th>
                            <th class="text-center">${locale_client_reservedtabel_cancelreservationform}</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestList}" var="item">
                            <tr>
                                <td>${item.hotelName}</td>
                                <td>${item.placesCount}</td>
                                <td>
                                    <form action="/hotelsminsk" class="form-inline">
                                        <%--<span>${item.hotelName} Reserved places count: ${item.placesCount}</span>--%>
                                        <input type="text" name="command" hidden="hidden" value="cancelreservation"/>
                                        <input type="text" name="requestid" hidden="hidden" value="${item.id}"/>
                                        <input type="text" name="placescount" hidden="hidden" value="${item.placesCount}"/>
                                        <input type="text" name="hotelid" value="${item.hotelId}" hidden="hidden"/>
                                        <button type="submit" class="btn btn-warning">${locale_client_reservedtabel_btncancelreservation} <span class="glyphicon glyphicon-remove"></span></button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>




</body>
</html>
