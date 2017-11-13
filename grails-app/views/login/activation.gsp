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
<div class="center-div">

    <div class="panel panel-default">
        <div class="panel-heading login-panel-heading-custom ">
            Activation Code
        </div>

    <div class="panel-body">
        <form id="activationForm" action="showHome">
            <div class="form-group">
                <label for="activationCode">Activation Code</label>
                <input type="text" class="form-control" id="activationCode" name="activationCode">

            </div>

            <div class="form-group">
                <g:submitButton name="loginBtn" value="Submit" type="submit"
                                class="btn btn-primary btn-block"/>
            </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>


