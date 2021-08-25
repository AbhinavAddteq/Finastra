package com.finastra.test.models;

import java.util.ArrayList;
import java.util.List;

public class ProjectParticipants {
    private List<String> accountIds;

    public ProjectParticipants() {
        this.accountIds = new ArrayList<>();
    }

    public ProjectParticipants(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    @Override
    public String toString() {
        return "ProjectParticipants{" +
                "accountIds=" + accountIds +
                '}';
    }
}
