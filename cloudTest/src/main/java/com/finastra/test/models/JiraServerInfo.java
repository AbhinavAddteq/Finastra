package com.finastra.test.models;

public class JiraServerInfo {
    private String baseUrl;
    private String serverTime;

    public JiraServerInfo(String baseUrl, String serverTime) {
        this.baseUrl = baseUrl;
        this.serverTime = serverTime;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }
}