package todoapp

import enums.Priority
import enums.Status

class Task {
    String title
    String description
    Priority priority
    Status status
    Date dueDate

    static belongsTo = [createdBy:EndUser]

    static constraints = {
        title blank: false, nullable: false
        description blank: false,nullable: false
        priority blank: false,nullable: false
        status blank: false,nullable: false
        dueDate blank: false,nullable: false
    }
}
