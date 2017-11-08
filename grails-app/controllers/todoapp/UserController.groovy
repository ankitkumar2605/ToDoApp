package todoapp

class UserController {

    def index() {

    }

    def signup(){
        EndUser endUser = new EndUser(userEmail:params.email, password: params.password)
        if(!endUser.save(flush:true))
            render "Cannot be registered"

        else
            render "Successfully registered!"
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
