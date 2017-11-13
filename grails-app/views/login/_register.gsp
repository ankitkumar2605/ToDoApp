<div class="panel panel-default">
    <div class="panel-heading login-panel-heading-custom">
        Register
    </div>

    <div class="panel-body">
        <form id="addUser" name="registration" action="registration">
            <div class="form-group">
                <label for="firstName">First Name *</label>

                <g:textField name="firstName" type="text" class="form-control" id="firstName"
                             value="${userCo?.firstName}"/>

                <div class="alert-danger">
                    <g:fieldError field="firstName" bean="${userCo}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="lastName">Last Name *</label>

                <g:textField name="lastName" type="text" class="form-control" id="lastName"
                             value="${userCo?.lastName}"/>

                <div class="alert-danger"><g:fieldError field="lastName" bean="${userCo}"/></div>
            </div>

            <div class="form-group">
                <label for="userEmail">Email *</label>

                <g:field name="userEmail" type="email" class="form-control" id="userEmail"
                         value="${userCo?.userEmail}"/>

                <div class="alert-danger"><g:fieldError field="email" bean="${userCo}"/></div>
            </div>


            <div class="form-group">
                <label for="password">Password *</label>

                <g:field name="password" type="password" class="form-control" id="password"
                         value="${userCo?.password}"/>
            </div>

            <div class="form-group">
                <label for="confirmPassword">Confirm Password *</label>

                <g:field name="confirmPassword" type="password" class="form-control" id="confirmPassword"/>
            </div>

            <g:hiddenField name="isActivated" value="false"/>
            <g:hiddenField name="isAdmin" value="false"/>

            <div class="form-group">
                <g:submitButton type="submit" name="submit" value="Register"
                                class="btn btn-primary btn-block"/>
            </div>
        </form>
    </div>
</div>