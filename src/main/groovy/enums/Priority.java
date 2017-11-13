package enums;

public enum Priority {
    HIGH,
    MEDIUM,
    LOW;

    public static Priority checkPriority(String priority) {

        if (priority.equals("High")) {

            return Priority.HIGH;

        }else if (priority.equals("Medium")) {

            return Priority.MEDIUM;

        } else{
            return Priority.LOW;
        }
    }
}
