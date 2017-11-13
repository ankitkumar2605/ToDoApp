package todoapp

import co.EndUserCo
import grails.transaction.Transactional

@Transactional
class LoginService {
    def mailService
    def sendActivationCode(EndUser endUser){
        def response =[:]
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
            response.put("success",true)
        } else
           response.put("success",false)
        return response
    }
}
