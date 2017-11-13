package todoapp

import co.EndUserCo
import grails.converters.JSON

class LoginController {
    def mailService
    def userService
    def loginService

    def index() {
        render(view: "login")

    }

    def login(String loginUserEmail, String loginPassword) {

        def response = userService.validateUser(loginUserEmail,loginPassword)
        if(response.success){
            session["user"] = response.user
            response.remove("user")
        }

        render(response as JSON)

    }

    def registration(EndUserCo endUserCo) {

        def response = userService.addUser(endUserCo)
        if(response.success){
            session["user"] = response.user
            response.remove("user")
        }

        render(response as JSON)
    }

    def sendActivationCode() {
        EndUser endUser = session["user"]
        def response = loginService.sendActivationCode(endUser)
        if(response.success)
            render(view: "activation")

    }

    def showHome(String activationCode) {
        EndUser invitee = session["user"]
        Invitation invitation = Invitation.findByInviteeAndActivationCode(invitee, activationCode)
        if (invitation) {
            render([success:true] as JSON)

        } else {
            render([success:false] as JSON)
        }
    }

}
