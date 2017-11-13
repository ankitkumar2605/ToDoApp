<div class="panel panel-default">
    <div class="panel-heading login-panel-heading-custom ">
        Login
    </div>

    <div class="panel-body">
        <form id="loginForm" action="login">
            <div class="form-group">
                <label for="loginUserEmail">User Email *</label>

                <g:textField name="loginUserEmail" class="form-control" id="loginUserEmail"/>
            </div>

            <div class="form-group">
                <label for="loginPassword">Password *</label>

                <g:field name="loginPassword" type="password" class="form-control" id="loginPassword"/>
            </div>

            <div>
                <span><g:link class="noUnderline" controller="login" style="color: blue"
                              action="showForgotPassword">Forgot Password</g:link>
                </span>
            </div>

            <div class="form-group">
                <g:submitButton name="loginBtn" value="Login" type="submit"
                                class="btn btn-primary btn-block"/>
            </div>

        </form>
    </div>
</div>
