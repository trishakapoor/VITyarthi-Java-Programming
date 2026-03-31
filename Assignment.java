package models;

import java.time.LocalDate;

public class Assignment {
    private String title;
    private String subject;
    private LocalDate deadline;
    private String priority;

    public Assignment(String title, String subject, LocalDate deadline, String priority) {
        this.title = title;
        this.subject = subject;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public LocalDate getDeadline() { return deadline; }
    public String getPriority() { return priority; }

    @Override
    public String toString() {
        return title + "," + subject + "," + deadline + "," + priority;
    }

    public String display() {
        return title + " | " + subject + " | Due: " + deadline + " | Priority: " + priority;
    }
}
