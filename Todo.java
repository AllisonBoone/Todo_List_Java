// Created class for single task.
class Task {
    String description;
    boolean isComplete;
    Task next;

    public Task (String description) {
        this.description = description;
        this.isComplete = false;
        this.next = null;
    }

    public void markCompleted() {
        this.isComplete = true;
    }
}