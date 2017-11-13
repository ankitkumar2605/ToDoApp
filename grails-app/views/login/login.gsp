
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <asset:stylesheet src="application.css"/>
    <asset:stylesheet src="login/login.css"/>
    <asset:javascript src="login/login.js"/>
    <asset:javascript src="application.js"/>


    <title></title>
</head>

<body>
<div class="row" style="padding: 2% 5%">
    <div class="col-md-6">
        <div class="row">
            <g:render template="/login/register"/>
        </div>
        </div>

    <div class="col-md-5 col-md-offset-1">
        <div class="row">
            <g:render template="/login/login"/>
        </div>

    </div>
</div>
</body>
</html>


