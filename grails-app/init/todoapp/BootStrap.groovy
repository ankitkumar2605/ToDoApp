package todoapp

import enums.Priority
import enums.Status

class BootStrap {

    def init = { servletContext ->
        createUsers()
    }
    def destroy = {
    }

    void createUsers(){
        EndUser user = new EndUser(userEmail: "ankit@gmail.com",password:"ankitkumar",firstName: "ankit",lastName: "kumar", isAdmin: false,isActivated: true)
        user.addToTasks(new Task(title: "Meeting",description: "Meeting with team",priority:Priority.HIGH,status: Status.DUE,dueDate:new Date()-1))
        if (user.save(flush:true,failOnError:true)) {
            log.info "${user} saved"
        } else {
            log.error "${user} cannot be saved--- ${user.errors.allErrors}"
        }
    }
}
