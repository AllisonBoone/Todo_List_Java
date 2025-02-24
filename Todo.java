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
    public void addTask (String description) {
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

// Created class for user.
class User {
    String name;
    TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }
}

// Created main class for users and their todo lists.
public class Todo {
    private static final int MAX_USERS = 10;
    private static User[] users = new User[MAX_USERS];
    private static int userCount = 0;

    // Created method to add a new user.
    public static boolean addUser (String name) {
        if (userCount >= MAX_USERS) {
            System.out.println("User limit reached.");
            return false;
        }

        users[userCount++] = new User(name);
        return true;
    }

    // Created method to get user by username.
    public static User getUser (String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].name.equals(name)) {
                return users[i];
            }
        }

        return null;
    }

    // Created users and their todo lists.
    public static void main (String[] args) {
        addUser("John");
        addUser("Jane");

        User john = getUser("John");
        if (john != null) {
            john.taskList.addTask("Grocery shop.");
            john.taskList.addTask("Take out trash.");
        }

        User jane = getUser ("Jane");
        if (jane != null) {
            jane.taskList.addTask("Make doctor appointment.");
            jane.taskList.addTask("Pick up mail.");
        }

        // Marking a task as completed.
        if (john != null) john.taskList.markTaskCompleted("Grocery shop.");

        if (jane != null) jane.taskList.markTaskCompleted("Pick up mail.");

        // Prints out users todo lists.
        System.out.println("John's Todo List:");
        if (john != null) john.taskList.printTasks();

        System.out.println("Jane's Todo List:");
        if (jane != null) jane.taskList.printTasks();
    }
}