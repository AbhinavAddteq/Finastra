package com.finastra.test.controllers;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.atlassian.connect.spring.AtlassianHostUser;
import com.atlassian.connect.spring.ContextJwt;
import com.finastra.test.Utilities;
import com.finastra.test.models.AppUser;
import com.finastra.test.models.Issue;
import com.finastra.test.models.JiraServerInfo;
import com.finastra.test.models.ProjectParticipants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ViewPokerPage {

    @Autowired
    private AtlassianHostRestClients atlassianHostRestClients;

    @RequestMapping(value = "/viewPoker", method = RequestMethod.GET)
    public ModelAndView getFieldValueSetup(@AuthenticationPrincipal AtlassianHostUser hostUser, @RequestParam() String boardId, @RequestParam() String projectId, @RequestParam() String accountId) {
        System.out.println("");

        ModelAndView model = new ModelAndView();

        System.out.println(Arrays.asList(boardId, projectId, accountId));

        model.setViewName("viewPoker");

        List<Issue> issueData = Utilities.getBoardIssues(atlassianHostRestClients, boardId, projectId, "assignee IN (currentUser()) || reporter = currentUser()");

        model.addObject("inputJQL", "assignee IN (currentUser()) || reporter = currentUser()");
        model.addObject("boardId", boardId);
        model.addObject("boardIssues", issueData);
        model.addObject("projectId", projectId);

        if (hostUser != null && hostUser.getHost() != null) {
            model.addObject("baseUrl", hostUser.getHost().getBaseUrl());
        }

        List<Issue> allBoardIssues = Utilities.getBoardIssues(atlassianHostRestClients, boardId, projectId, "assignee IN (currentUser()) || reporter = currentUser()");
        model.addObject("allBoardIssues", allBoardIssues);

        ProjectParticipants participants = Utilities.getProjectParticipants(atlassianHostRestClients, projectId);
        if (participants != null) {
            List<AppUser> appUsers = Utilities.getAppUsers(atlassianHostRestClients, participants.getAccountIds());
            System.out.println(appUsers);
            model.addObject("participants", appUsers);
        }

        return model;
    }

    @ContextJwt
    @RequestMapping(value = "/viewPoker/jql", method = RequestMethod.GET)
    public ModelAndView getFieldValueSetup(@AuthenticationPrincipal AtlassianHostUser hostUser, @RequestParam() String jql, @RequestParam() String boardId) {
        ModelAndView model = new ModelAndView();

        System.out.println("-----------------JQL------------------------");
        System.out.println(jql);

        model.setViewName("viewPoker :: boardIssuesFragment");

        List<Issue> issueData = Utilities.getBoardIssues(atlassianHostRestClients, boardId, null, jql);

        model.addObject("inputJQL", jql);
        model.addObject("boardId", boardId);
        model.addObject("boardIssues", issueData);


        if (hostUser != null && hostUser.getHost() != null) {
            model.addObject("baseUrl", hostUser.getHost().getBaseUrl());
        }

        return model;
    }

    @ContextJwt
    @RequestMapping(value = "/viewPoker/selected", method = RequestMethod.GET)
    public ModelAndView getSelectedIssue(@AuthenticationPrincipal AtlassianHostUser hostUser, @RequestParam() String issueKey) {
        ModelAndView model = new ModelAndView();

        System.out.println("-----------------issueKey------------------------");
        System.out.println(issueKey);

        model.setViewName("viewPoker :: selectedIssueFragment");

        Issue selectedIssue = Utilities.getJiraIssueData(atlassianHostRestClients, issueKey);

        model.addObject("selectedIssue", selectedIssue);

        if (hostUser != null && hostUser.getHost() != null) {
            model.addObject("baseUrl", hostUser.getHost().getBaseUrl());
        }

        return model;
    }

    @ContextJwt
    @RequestMapping(value = "/viewPoker/participant", method = RequestMethod.GET)
    public ModelAndView getAndSetParticipant(@AuthenticationPrincipal AtlassianHostUser hostUser, @RequestParam() String projectId) {
        ModelAndView model = new ModelAndView();

        model.setViewName("viewPoker :: participantsFragment");

        ProjectParticipants participants = Utilities.getProjectParticipants(atlassianHostRestClients, projectId);
        List<String> accountIds = new ArrayList<>();

        if (participants != null && participants.getAccountIds() != null && !participants.getAccountIds().isEmpty()) {
            accountIds = participants.getAccountIds();
        }

        if (hostUser != null && hostUser.getUserAccountId().isPresent() && (accountIds.isEmpty() || !accountIds.contains(hostUser.getUserAccountId().get()))) {
            accountIds.add(hostUser.getUserAccountId().get());
            participants = Utilities.setProjectParticipants(atlassianHostRestClients, projectId, new ProjectParticipants(accountIds));
        }

        if (participants != null) {
            model.addObject("participants", Utilities.getAppUsers(atlassianHostRestClients, participants.getAccountIds()));
        }

        if (hostUser != null && hostUser.getHost() != null) {
            model.addObject("baseUrl", hostUser.getHost().getBaseUrl());
        }

        model.addObject("projectId", projectId);
        return model;
    }
}
