package todoapp

import co.TaskCO
import enums.Status
import grails.converters.JSON

class TaskController {

    def index() {
        render(view: 'task', model: [todoList: Task.list()])
    }

    def loadTasks(){
        EndUser endUser = session["user"]
        def todoList = Task.findAllByCreatedByAndStatus(endUser,Status.DUE)
        render(view: 'task', model: [todoList: todoList])

    }

    def addTask(TaskCO taskCO) {

        if (taskCO.hasErrors()) {
            taskCO.errors.allErrors.each {
                println it
            }
            render([success:false,isParamsIncorrect:true] as JSON)
        } else {
            Task task = new Task()
            task.properties = taskCO
            task.createdBy = session["user"]

            if (!task.save(flush: true)) {
                task.errors.allErrors.each {
                    println it
                }
                render([success:false] as JSON)
            } else {
                render([success:true] as JSON)
            }

        }
    }

    def taskByStatus() {
        EndUser endUser = session["user"]
        println params.status
        def todoList = Task.findAllByCreatedByAndStatus(endUser,params.status)
        render(view: 'task', model: [todoList: todoList])
    }

    def updateTaskStatus() {
        Task task = Task.get(params.id)
        task.status = Status.DONE
        if (!task.save(flush: true))
            render([success:false] as JSON)

        else
            render([success:true] as JSON)
    }

    def removeTask() {
        Task task = Task.get(params.id)
        if (task && !task.delete(flush: true)) {
            render([success:true] as JSON)
        } else {
            render([success:false] as JSON)
        }
    }

    def overdueTasks() {
        println Task.createCriteria().list {
            projections {
                property("title")
            }
            lt('dueDate', new Date())
            eq('status', Status.DUE)
        }
        render "Yo"
    }


}
