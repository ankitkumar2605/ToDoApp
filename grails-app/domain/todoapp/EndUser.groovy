package todoapp

class EndUser{
    String userEmail
    String password
    String firstName
    String lastName
    String photoUrl
    Boolean isActivated
    Boolean isAdmin

    static hasMany = [tasks:Task]

    static constraints = {
        userEmail blank: false,email:true,nullable:false
        password blank: false,nullable: false
        firstName blank: true,nullable: true
        lastName blank: true,nullable: true
        photoUrl blank: true,nullable: true
        isActivated blank: false,nullable:false
        isAdmin blank: false,nullable:false
    }
}