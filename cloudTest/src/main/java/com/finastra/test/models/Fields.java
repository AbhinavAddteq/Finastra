package com.finastra.test.models;

public class Fields {
    private String summary;
    private Status status;
    private Assignee assignee;
    private String description;

    public Fields(String summary, Status status, Assignee assignee, String description) {
        this.summary = summary;
        this.status = status;
        this.assignee = assignee;
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
