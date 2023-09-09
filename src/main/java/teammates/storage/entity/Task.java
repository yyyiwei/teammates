package teammates.storage.entity;

import java.time.Instant;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Translate;

/**
 * Represents a task entity.
 */
@Entity
@Index
public class Task extends BaseEntity {

    @Id
    private String taskId;

    private String taskName;
    private String assignedTo;
    private String status;

    @Translate(InstantTranslatorFactory.class)
    private Instant dueDate;

    @SuppressWarnings("unused")
    private Task() {
        // required by Objectify
    }

    public Task(String taskName, String assignedTo, String status, Instant dueDate) {
        this.taskName = taskName;
        this.assignedTo = assignedTo;
        this.status = status;
        this.dueDate = dueDate;
        this.taskId = generateId(this.taskName, this.assignedTo);
    }

    /**
     * Generates an unique ID for the task.
     */
    public static String generateId(String taskName, String assignedTo) {
        // Format is taskName%assignedTo
        return taskName + '%' + assignedTo;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", taskName=" + taskName + ", assignedTo=" + assignedTo + ", status=" + status
                + ", dueDate=" + dueDate + "]";
    }
}
