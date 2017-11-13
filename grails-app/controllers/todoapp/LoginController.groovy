package todoapp

import co.EndUserCo
import grails.converters.JSON

class LoginController {
    def mailService

    def index() {
        render(view: "login")

    }

    def login(String loginUserEmail, String loginPassword) {


        EndUser user = EndUser.findByUserEmailAndPassword(loginUserEmail, loginPassword)
        if (user && user.isActivated) {
            session["user"] = user
            render([success: true, isActive: true] as JSON)

        } else if (user && !user.isActivated) {
            session["user"] = user
            render([success: true, isActive: false] as JSON)
        } else {
            session.invalidate()
            render([success: false] as JSON)
        }

    }

    def registration(EndUserCo endUserCo) {

        if (endUserCo.hasErrors()) {
            endUserCo.errors.allErrors.each {
                println it
            }
            render([success: false, isParamsIncorrect: true] as JSON)
        } else {
            if (EndUser.findByUserEmail(endUserCo.userEmail)) {
                render([success: false, isUserExists: true] as JSON)
            } else {
                EndUser endUser = new EndUser()
                endUser.properties = endUserCo

                if (!endUser.save(flush: true))
                    render([success: false] as JSON)

                else {
                    session["user"] = endUser
                    render([success: true, isUserExists: false] as JSON)
                }
            }
        }
    }

    def sendActivationCode() {
        EndUser endUser = session["user"]
        def activationCode = UUID.randomUUID().toString()
        Invitation invitation = new Invitation(invitee: endUser, activationCode: activationCode)
        if (invitation.hasErrors()) {
            invitation.errors.allErrors.each { println it }
        }
        if (invitation.save(flush: true, failOnError: true)) {
            runAsync {
                mailService.sendMail {
                    to endUser.userEmail
                    from "ankit8826648806@gmail.com"
                    subject 'Activation Code: ToDo'
                    text "hii This is your activation code" + "\n" + activationCode
                }
            }
            render(view: "activation")
        } else
            render "Please try again"
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
