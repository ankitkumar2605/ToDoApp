package todoapp

import co.TaskCO
import enums.Status
import grails.converters.JSON
import grails.transaction.Transactional

@Transactional
class TaskService {

    def dueTaskOfUser(EndUser endUser, Status status){
        def todoList = Task.findAllByCreatedByAndStatus(endUser,status)
        return todoList

    }

    def createTask(TaskCO taskCO,EndUser endUser){
        def response = [:]
        if (taskCO.hasErrors()) {
            taskCO.errors.allErrors.each {
                println it
            }
            response.put("success",false)
            response.put("isParamsIncorrect",true)
        } else {
            Task task = new Task()
            task.properties = taskCO
            task.createdBy = endUser

            if (!task.save(flush: true)) {
                task.errors.allErrors.each {
                    println it
                }
                response.put("success",false)
            } else {
                response.put("success",true)
            }

        }
        return response
    }
}
