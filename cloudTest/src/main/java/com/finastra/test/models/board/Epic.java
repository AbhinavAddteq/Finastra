package com.finastra.test.models.board;

public class Epic {
    private int id;
    private String self;
    private String name;
    private String summary;
    Color color;
    private boolean done;

    public Epic(int id, String self, String name, String summary, Color color, boolean done) {
        this.id = id;
        this.self = self;
        this.name = name;
        this.summary = summary;
        this.color = color;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}