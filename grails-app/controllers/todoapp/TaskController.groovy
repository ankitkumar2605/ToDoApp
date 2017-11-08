package todoapp

import enums.Status

class TaskController {

    def index() {
        render "Task"
    }

    def saveTask(){
        Task task = new Task(title: params.title,description: params.description,priority: params.priority,createdBy: EndUser.get(1),
        dueDate: new Date())
        if(!task.save(flush:true))
            render "Task not created"

        else
            render "Successfully created!"

    }

    def getTaskByStatus(){
        def taskList = Task.findByStatus(Status.DUE)
    }

    def setTaskStatus(){
        Task task = Task.get(1)
        task.status = Status.DUE
        if(!task.save(flush:true))
            render "Task not updated"

        else
            render "Successfully updated!"

    }

    def removeTask(){
        EndUser endUser = EndUser.get(1)
        Task task = Task.get(1)
        endUser.removeFromTasks(task)
    }

    def overdueTasks(){
        println Task.createCriteria().list {
            projections {
                property("title")
            }
            lt('dueDate',new Date())
            eq('status',Status.DUE)
        }
        render "Yo"
    }


}
