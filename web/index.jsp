<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 11/16/2017
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<html>
<head>
  <title>Авторизация</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%--<link rel="stylesheet" href="resources/css/bootstrap.min.css">--%>
  <%--<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">--%>
  <script src="resources/js/jquery-3.2.1.js"></script>
</head>
<body>

  <jsp:include page="jsp/block/sitenavbar.jsp"/>


  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <form name="loginForm" method="POST" action="hotelsminsk" >
          <input type="hidden" name="command" value="login" />
          <h3 class="text-center">${locale_authorization_header}: </h3>
          <div class="form-group">
            <label>${locale_authorization_label_login}:</label>
            <input type="text" name="login" value="" size="20" class="form-control"/>
          </div>

          <div class="form-group">
            <label>${locale_authorization_label_password}:</label>
            <input type="password" name="password" value="" size="20" class="form-control"/>
          </div>
          <b style="color: red;">${errorLoginOrPassword}</b>
          <br />
          <input type="submit" value="${locale_authorization_btn}" class="btn btn-success btn-block"/>
        </form>
      </div>
    </div>
  </div>
</body>
<%session.removeAttribute("errorLoginOrPassword");%>
</html>
