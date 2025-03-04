public class Task {
    private int number;
    private String description;
    private String status;
    private int daysInProcessing;

    public Task(int number, String description, String status, int daysInProcessing) {
        this.number = number;
        this.description = description;
        this.status = status;
        this.daysInProcessing = daysInProcessing;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getDaysInProcessing() {
        return daysInProcessing;
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", daysInProcessing=" + daysInProcessing +
                '}';
    }
}
