package enums;

public enum Status {
    DUE,
    DONE;

    public static Status checkStatus(String status){
        if(status.equals("Due"))
            return Status.DUE;
        else
            return Status.DONE;
    }
}
