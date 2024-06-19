import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private ArrayList<String> tasks;

    public ToDoListApp() {
        tasks = new ArrayList<>();
    }

    // Method to add a task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Added: " + task);
    }

    // Method to remove a task
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Removed: " + removedTask);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    // Method to display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Main method to run the app
    public static void main(String[] args) {
        ToDoListApp app = new ToDoListApp();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the To-Do List App!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            switch (command) {
                case "1":
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine();
                    app.addTask(task);
                    break;
                case "2":
                    System.out.print("Enter task number to remove: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        app.removeTask(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    break;
                case "3":
                    app.displayTasks();
                    break;
                case "4":
                    System.out.println("Exiting the To-Do List App. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}