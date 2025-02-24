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

// Created class for a list of tasks.
class TaskList {
    private Task head;

    // Created method to add new task.
    public void addTask(String description) {
        Task newTask = new Task(description);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newTask;

        }
    }

    // Created method to mark tasks as completed.
    public boolean markTaskCompleted (String description) {
        Task temp = head;

        while (temp != null) {
            if (temp.description.equals(description)) {
                temp.markCompleted();
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // Created method to print tasks in a list.
    public void printTasks() {
        Task temp = head;

        if (temp == null) {
            System.out.println("No available tasks...");
            return;
        }

        while (temp != null) {
            System.out.println("- " + temp.description + " [" + (temp.isComplete ? "Completed" : "Pending") + "]");
            temp = temp.next;
        }
    }
}