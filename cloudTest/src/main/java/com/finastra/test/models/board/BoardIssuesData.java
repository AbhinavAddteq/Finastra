package com.finastra.test.models.board;

import com.finastra.test.models.Issue;

public class BoardIssuesData {
    private String expand;
    private int startAt;
    private int maxResults;
    private int total;
    Issue[] issues;

    public BoardIssuesData(String expand, int startAt, int maxResults, int total, Issue[] issues) {
        this.expand = expand;
        this.startAt = startAt;
        this.maxResults = maxResults;
        this.total = total;
        this.issues = issues;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public int getStartAt() {
        return startAt;
    }

    public void setStartAt(int startAt) {
        this.startAt = startAt;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Issue[] getIssues() {
        return issues;
    }

    public void setIssues(Issue[] issues) {
        this.issues = issues;
    }
}