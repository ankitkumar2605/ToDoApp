package todoapp

class BootStrap {

    def init = { servletContext ->
        createUsers()
    }
    def destroy = {
    }

    void createUsers(){
        EndUser user = new EndUser(userEmail: "ankit@gmail.com",password:"asdfghA12",isAdmin: false,isActivated: false)
        if (user.save(flush:true,failOnError:true)) {
            log.info "${user} saved"
        } else {
            log.error "${user} cannot be saved--- ${user.errors.allErrors}"
        }
    }
}
