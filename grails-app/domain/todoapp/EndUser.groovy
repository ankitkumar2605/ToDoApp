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
        firstName blank: false,nullable: false
        lastName blank: false,nullable: false
        photoUrl blank: true,nullable: true
        isActivated blank: false,nullable:false
        isAdmin blank: false,nullable:false
    }
}