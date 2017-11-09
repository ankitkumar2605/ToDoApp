package todoapp

import co.EndUserCo
import org.springframework.validation.BindingResult


class UserController {

    def index() {

    }

    def signup(EndUserCo endUserCo){
        if(endUserCo.hasErrors()){
            render "Unsuccessfull"
        }else {
            EndUser endUser = new EndUser()
            endUser.properties = endUserCo
            if (!endUser.save(flush: true))
                render "Cannot be registered"

            else
                render "Successfully registered!"
        }
    }

    def login(){
        EndUser endUser = EndUser.findByUserEmailAndPassword(params.userEmail,params.password)
        if(endUser && endUser.isActivated){
             render "Success"

        }else if(endUser && !endUser.isActivated){
            render "Not Active"

        }else{
            render "Not Found"

        }
    }
}
