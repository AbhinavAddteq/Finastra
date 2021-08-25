package com.finastra.test;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.finastra.test.models.*;
import com.finastra.test.models.board.BoardIssuesData;
import org.springframework.web.client.RestClientException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

    public static Issue getJiraIssueData(AtlassianHostRestClients atlassianHostRestClients, String issueKey) {
        String url = "/rest/api/2/issue/" + issueKey;

        try {

            return atlassianHostRestClients.authenticatedAsHostActor()
                    .getForObject(url, Issue.class);

        } catch (RestClientException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<Issue> getBoardIssues(AtlassianHostRestClients atlassianHostRestClients, String boardId, String projectId, String jql) {
        String url = "/rest/agile/1.0/board/" + boardId + "/issue?jql=" + jql + "&maxResults=50&startAt=";

        int startAt = 0;

        List<Issue> issues = new ArrayList<>();

        BoardIssuesData boardIssuesData = getBoardIssuesData(atlassianHostRestClients, url, startAt);

        while (boardIssuesData != null) {
            issues.addAll(Arrays.asList(boardIssuesData.getIssues()));

            startAt += 50;

            boardIssuesData = startAt < boardIssuesData.getTotal() ? getBoardIssuesData(atlassianHostRestClients, url, startAt) : null;
        }

        return issues;
    }

    private static BoardIssuesData getBoardIssuesData(AtlassianHostRestClients atlassianHostRestClients, String url, int startAt) {
        try {

            return atlassianHostRestClients.authenticatedAsHostActor()
                    .getForObject(url + startAt, BoardIssuesData.class);

        } catch (RestClientException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static JiraServerInfo getJiraServerInfo(AtlassianHostRestClients atlassianHostRestClients) {

        try {
            return atlassianHostRestClients.authenticatedAsAddon()
                    .getForObject("/rest/api/2/serverInfo",
                            JiraServerInfo.class);

        } catch (RestClientException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static ProjectParticipants getProjectParticipants(AtlassianHostRestClients atlassianHostRestClients, String projectId) {

        try {
            ProjectProperty projectProperty = atlassianHostRestClients.authenticatedAsAddon()
                    .getForObject("/rest/api/2/project/"+ projectId + "/properties/projectParticipants",
                            ProjectProperty.class);

            return projectProperty != null ? projectProperty.getValue() : null;

        } catch (RestClientException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static ProjectParticipants setProjectParticipants(AtlassianHostRestClients atlassianHostRestClients, String projectId, ProjectParticipants projectParticipants) {
        System.out.println(projectParticipants);

        try {
            atlassianHostRestClients.authenticatedAsAddon()
                    .put("/rest/api/2/project/"+ projectId + "/properties/projectParticipants",
                            projectParticipants);
            return projectParticipants;

        } catch (RestClientException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static AppUser getAppUser(AtlassianHostRestClients atlassianHostRestClients, String accountId) {

        try {
            return atlassianHostRestClients.authenticatedAsAddon()
                    .getForObject("/rest/api/2/user?accountId=" + accountId,
                            AppUser.class);

        } catch (RestClientException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static List<AppUser> getAppUsers(AtlassianHostRestClients atlassianHostRestClients, List<String> accountIds) {
        List<AppUser> appUsers = new ArrayList<>();

        if (accountIds != null) {
            for (String accountId : accountIds) {
                AppUser appUser = getAppUser(atlassianHostRestClients, accountId);
                if (appUser != null) {
                    appUsers.add(appUser);
                }
            }
        }

        return appUsers;
    }
}
