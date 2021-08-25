package com.finastra.test.models;

public class ProjectProperty {
    private String key;
    private ProjectParticipants value;

    public ProjectProperty(String key, ProjectParticipants value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ProjectParticipants getValue() {
        return value;
    }

    public void setValue(ProjectParticipants value) {
        this.value = value;
    }
}
