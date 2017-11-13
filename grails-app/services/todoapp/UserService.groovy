package todoapp

import co.EndUserCo
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional
class UserService {

    def validateUser(String loginUserEmail,loginPassword) {
        def response = [:]
        EndUser user = EndUser.findByUserEmailAndPassword(loginUserEmail, loginPassword)
        if (user && user.isActivated) {
            response.put("user",user)
            response.put("success",true)
            response.put("isActive",true)
        } else if (user && !user.isActivated) {
            response.put("user",user)
            response.put("success",true)
            response.put("isActive",false)
        } else {
            response.put("success", false)
        }
        return response

    }
    def addUser(EndUserCo endUserCo){
        def response = [:]
        if (endUserCo.hasErrors()) {
            endUserCo.errors.allErrors.each {
                println it
            }
            response.put("success",false)
            response.put("isParamsIncorrect",true)
        } else {
            if (EndUser.findByUserEmail(endUserCo.userEmail)) {
                response.put("success",false)
                response.put("isUserExists",true)

            } else {
                EndUser endUser = new EndUser()
                endUser.properties = endUserCo

                if (!endUser.save(flush: true))
                    response.put("success",true)

                else {
                    response.put("user",endUser)
                    response.put("success",true)
                    response.put("isUserExists",false)
                }
            }
        }
        return response


    }
}
