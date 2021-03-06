package com.finastra.test.models;

public class Issue {

    private String id;
    private String key;
    private Fields fields;

    public Issue() {
        this.id = "";
        this.key = "";
        this.fields = null;
    }

    public Issue(String id, String key, Fields fields) {
        this.id = id;
        this.key = key;
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", key='" + key + '\'' +
                ", fields=" + fields +
                '}';
    }
}
