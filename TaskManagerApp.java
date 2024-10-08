// src/TaskManagerApp.java
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManagerApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTask Manager Menu:");
            System.out.println("1. Create Task");
            System.out.println("2. Read Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createTask(scanner);
                    break;
                case 2:
                    readTasks();
                    break;
                case 3:
                    updateTask(scanner);
                    break;
                case 4:
                    deleteTask(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void createTask(Scanner scanner) {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        Task newTask = new Task(taskIdCounter++, name, description);
        tasks.add(newTask);
        System.out.println("Task created successfully!");
    }

    private static void readTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void updateTask(Scanner scanner) {
        System.out.print("Enter task ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new description: ");
                String newDescription = scanner.nextLine();
                task.setName(newName);
                task.setDescription(newDescription);
                System.out.println("Task updated successfully!");
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }

    private static void deleteTask(Scanner scanner) {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();

        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                System.out.println("Task deleted successfully!");
                return;
            }
        }
        System.out.println("Task with ID " + id + " not found.");
    }
}
