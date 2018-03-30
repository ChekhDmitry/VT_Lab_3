
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String ruOption ="";
    String engOption ="";
    if(((String)session.getAttribute("locale")).equals("ru")) {
        ruOption = "selected='selected'";
        engOption = "";
    }else{
        engOption = "selected='selected'";
        ruOption = "";
    }
    response.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=utf-8");
%>
<div class="navbar navbar-inverse navbar-fixed-top" >
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/hotelsminsk"><span class="glyphicon glyphicon-calendar"></span> MinskHotels</a>
        </div>

        <div class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" action="/hotelsminsk">
                <input type="text" name="command" value="logout" hidden="hidden">
                <button type="submit" class="btn btn-danger">${locale_btn_logout} <span class="glyphicon glyphicon-log-out"></span></button>
            </form>
            <form class="navbar-form navbar-right" action="/hotelsminsk" id="locale_form">
                <input type="text" name="command" value="localization" hidden="hidden"/>
                <div class="form-group">
                    <select class="form-control" name="locale" onchange="$('#locale_form').submit();">
                        <option id="ru_option" value="ru" <%=ruOption%>>RU</option>
                        <option id="eng_option" value="eng" <%=engOption%>>ENG</option>
                    </select>
                </div>
            </form>
        </div>
    </div>
</div>
<br/>
<br/>
<br/>
