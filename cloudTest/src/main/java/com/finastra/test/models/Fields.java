package com.finastra.test.models;

import com.finastra.test.models.board.*;

public class Fields {
    private String summary;
    private Status status;
    Assignee assignee;
    private String description;

    IssueType issuetype;
    Priority priority;

    private boolean flagged;
    Sprint sprint;
    ClosedSprints[] closedSprints;
    Project project;
    Epic epic;
    private String updated;
    Timetracking timetracking;

    public Fields(String summary, Status status, Assignee assignee, String description, IssueType issuetype, Priority priority, boolean flagged, Sprint sprint, ClosedSprints[] closedSprints, Project project, Epic epic, String updated, Timetracking timetracking) {
        this.summary = summary;
        this.status = status;
        this.assignee = assignee;
        this.description = description;
        this.issuetype = issuetype;
        this.priority = priority;
        this.flagged = flagged;
        this.sprint = sprint;
        this.closedSprints = closedSprints;
        this.project = project;
        this.epic = epic;
        this.updated = updated;
        this.timetracking = timetracking;
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

    public IssueType getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(IssueType issuetype) {
        this.issuetype = issuetype;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public ClosedSprints[] getClosedSprints() {
        return closedSprints;
    }

    public void setClosedSprints(ClosedSprints[] closedSprints) {
        this.closedSprints = closedSprints;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Epic getEpic() {
        return epic;
    }

    public void setEpic(Epic epic) {
        this.epic = epic;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Timetracking getTimetracking() {
        return timetracking;
    }

    public void setTimetracking(Timetracking timetracking) {
        this.timetracking = timetracking;
    }
}
