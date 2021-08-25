package com.finastra.test.models.board;

public class Sprint {
    private int id;
    private String self;
    private String state;
    private String name;
    private String goal;

    public Sprint(int id, String self, String state, String name, String goal) {
        this.id = id;
        this.self = self;
        this.state = state;
        this.name = name;
        this.goal = goal;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
