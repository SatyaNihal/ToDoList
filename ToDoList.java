package todo;
import java.util.*;

public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description, int priority) {
        Task task = new Task(description, priority);
        tasks.add(task);
        System.out.println("Added: " + description);
    }

    public void markTaskAsCompleted(int index) {
        if (isValid(index)) {
            tasks.get(index).setCompleted(true);
            System.out.println("Marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void removeTask(int index) {
        if (isValid(index)) {
            Task removed = tasks.remove(index);
            System.out.println("Removed: " + removed.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your list is empty.");
            return;
        }
        System.out.println("\nSatya's To Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ") " + tasks.get(i));
        }
    }

    public void showPendingTasks() {
        boolean found = false;
        System.out.println("\nPending Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            if (!tasks.get(i).isCompleted()) {
                System.out.println((i + 1) + ") " + tasks.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No pending tasks.");
        }
    }

    public void showCompletedTasks() {
        boolean found = false;
        System.out.println("\nCompleted Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isCompleted()) {
                System.out.println((i + 1) + ") " + tasks.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No completed tasks yet.");
        }
    }

    public void sortByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority));
        System.out.println("Sorted by priority.");
    }

    private boolean isValid(int index) {
        return index >= 0 && index < tasks.size();
    }
}
