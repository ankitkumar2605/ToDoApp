package todoapp

class Invitation {
    EndUser invitee
    String activationCode

    static constraints = {
        invitee blank:false,nullable: false
        activationCode blank: false,nullable: false
    }
}
