package com.finastra.test.models.board;

public class Timetracking {
    private String originalEstimate;
    private String remainingEstimate;
    private String timeSpent;
    private int originalEstimateSeconds;
    private int remainingEstimateSeconds;
    private int timeSpentSeconds;

    public Timetracking(String originalEstimate, String remainingEstimate, String timeSpent, int originalEstimateSeconds, int remainingEstimateSeconds, int timeSpentSeconds) {
        this.originalEstimate = originalEstimate;
        this.remainingEstimate = remainingEstimate;
        this.timeSpent = timeSpent;
        this.originalEstimateSeconds = originalEstimateSeconds;
        this.remainingEstimateSeconds = remainingEstimateSeconds;
        this.timeSpentSeconds = timeSpentSeconds;
    }

    public String getOriginalEstimate() {
        return originalEstimate;
    }

    public void setOriginalEstimate(String originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    public String getRemainingEstimate() {
        return remainingEstimate;
    }

    public void setRemainingEstimate(String remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getOriginalEstimateSeconds() {
        return originalEstimateSeconds;
    }

    public void setOriginalEstimateSeconds(int originalEstimateSeconds) {
        this.originalEstimateSeconds = originalEstimateSeconds;
    }

    public int getRemainingEstimateSeconds() {
        return remainingEstimateSeconds;
    }

    public void setRemainingEstimateSeconds(int remainingEstimateSeconds) {
        this.remainingEstimateSeconds = remainingEstimateSeconds;
    }

    public int getTimeSpentSeconds() {
        return timeSpentSeconds;
    }

    public void setTimeSpentSeconds(int timeSpentSeconds) {
        this.timeSpentSeconds = timeSpentSeconds;
    }
}