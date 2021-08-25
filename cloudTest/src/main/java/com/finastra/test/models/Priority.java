package com.finastra.test.models;

public class Priority {
    private String self;
    private String iconUrl;
    private String name;
    private String id;

    public Priority(String self, String iconUrl, String name, String id) {
        this.self = self;
        this.iconUrl = iconUrl;
        this.name = name;
        this.id = id;
    }

    // Getter Methods

    public String getSelf() {
        return self;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    // Setter Methods

    public void setSelf(String self) {
        this.self = self;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}