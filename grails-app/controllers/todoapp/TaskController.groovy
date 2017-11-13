package todoapp

import co.TaskCO
import enums.Status
import grails.converters.JSON

class TaskController {
    def taskService

    def index() {
        render(view: 'task')
    }

    def loadTasks() {
        EndUser endUser = session["user"]
       Status status=  params.status
        def todoList = taskService.dueTaskOfUser(endUser,status)
        render([todoList: todoList] as JSON)

    }

    def addTask(TaskCO taskCO) {
        EndUser endUser = session["user"]
        def response = taskService.createTask(taskCO, endUser)
        render(response as JSON)
    }


    def taskByStatus() {
        EndUser endUser = session["user"]
        println params.status
        def todoList = Task.findAllByCreatedByAndStatus(endUser, params.status)
        render([todoList: todoList] as JSON)
    }

    def updateTaskStatus() {
        Task task = Task.get(params.id)
        task.status = Status.DONE
        if (!task.save(flush: true))
            render([success: false] as JSON)

        else
            render([success: true] as JSON)
    }

    def removeTask() {
        Task task = Task.get(params.id)
        if (task && !task.delete(flush: true)) {
            render([success: true] as JSON)
        } else {
            render([success: false] as JSON)
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
