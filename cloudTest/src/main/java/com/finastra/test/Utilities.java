package com.finastra.test;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.finastra.test.models.Issue;
import org.springframework.web.client.RestClientException;

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
}
