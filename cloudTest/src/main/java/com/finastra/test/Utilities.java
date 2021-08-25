package com.finastra.test;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.finastra.test.models.Issue;
import com.finastra.test.models.JiraServerInfo;
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
}
