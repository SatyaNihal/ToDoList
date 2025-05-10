package todo;
import java.util.*;

public class ToDoApp {
    private static ToDoList todoList = new ToDoList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Satya's To Do List!");

        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1: addTask(); break;
                case 2: completeTask(); break;
                case 3: deleteTask(); break;
                case 4: todoList.showAllTasks(); break;
                case 5: todoList.showPendingTasks(); break;
                case 6: todoList.showCompletedTasks(); break;
                case 7: todoList.sortByPriority(); break;
                case 8: running = false; break;
                default: System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("Menu:");
        System.out.println("1. Add task");
        System.out.println("2. Mark task as done");
        System.out.println("3. Delete task");
        System.out.println("4. Show all tasks");
        System.out.println("5. Show pending tasks");
        System.out.println("6. Show completed tasks");
        System.out.println("7. Sort tasks by priority");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void addTask() {
        System.out.print("Task description: ");
        String desc = scanner.nextLine().trim();
        System.out.print("Priority (1=high, 5=low): ");
        int p;
        try {
            p = Integer.parseInt(scanner.nextLine().trim());
            if (p < 1 || p > 5) p = 3;
        } catch (Exception e) {
            p = 3;
        }
        todoList.addTask(desc, p);
    }

    private static void completeTask() {
        todoList.showAllTasks();
        System.out.print("Which task to mark done? ");
        try {
            int n = Integer.parseInt(scanner.nextLine().trim());
            todoList.markTaskAsCompleted(n - 1);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }

    private static void deleteTask() {
        todoList.showAllTasks();
        System.out.print("Which task to remove? ");
        try {
            int n = Integer.parseInt(scanner.nextLine().trim());
            todoList.removeTask(n - 1);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
}
