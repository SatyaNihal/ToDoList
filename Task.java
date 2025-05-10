package todo;
import java.util.*;

public class Task {
    private String description;
    private boolean completed;
    private int priority;

    public Task(String description, int priority) {
        this.description = description;
        this.completed = false;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public String toString() {
        String status = completed ? "[X]" : "[ ]";
        return status + " Priority: " + priority + " - " + description;
    }
}
