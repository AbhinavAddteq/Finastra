package com.finastra.test.controllers;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.atlassian.connect.spring.ContextJwt;
import com.finastra.test.Utilities;
import com.finastra.test.models.Issue;
import com.finastra.test.models.JiraServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class ViewPokerPage {

    @Autowired
    private AtlassianHostRestClients atlassianHostRestClients;

    @RequestMapping(value = "/viewPoker", method = RequestMethod.GET)
    public ModelAndView getFieldValueSetup(@RequestParam() String boardId, @RequestParam() String projectId, @RequestParam() String accountId) {
        ModelAndView model = new ModelAndView();

        System.out.println(Arrays.asList(boardId, projectId, accountId));

        model.setViewName("viewPoker");

        List<Issue> issueData = Utilities.getBoardIssues(atlassianHostRestClients, boardId, projectId, "assignee IN (currentUser()) || reporter = currentUser()");

        model.addObject("inputJQL", "assignee IN (currentUser())");
        model.addObject("boardId", boardId);
        model.addObject("boardIssues", issueData);

        JiraServerInfo jiraServerInfo = Utilities.getJiraServerInfo(atlassianHostRestClients);
        if (jiraServerInfo != null) {
            model.addObject("baseUrl", jiraServerInfo.getBaseUrl());
        }

        List<Issue> allBoardIssues = Utilities.getBoardIssues(atlassianHostRestClients, boardId, projectId, "assignee IN (currentUser()) || reporter = currentUser()");
        model.addObject("allBoardIssues", allBoardIssues);
        return model;
    }

    @ContextJwt
    @RequestMapping(value = "/viewPoker/jql", method = RequestMethod.GET)
    public ModelAndView getFieldValueSetup(@RequestParam() String jql, @RequestParam() String boardId) {
        ModelAndView model = new ModelAndView();

        System.out.println("-----------------JQL------------------------");
        System.out.println(jql);

        model.setViewName("viewPoker :: boardIssuesFragment");

        List<Issue> issueData = Utilities.getBoardIssues(atlassianHostRestClients, boardId, null, jql);

        model.addObject("inputJQL", jql);
        model.addObject("boardId", boardId);
        model.addObject("boardIssues", issueData);

        JiraServerInfo jiraServerInfo = Utilities.getJiraServerInfo(atlassianHostRestClients);
        if (jiraServerInfo != null) {
            model.addObject("baseUrl", jiraServerInfo.getBaseUrl());
        }

        return model;
    }

    @ContextJwt
    @RequestMapping(value = "/viewPoker/selected", method = RequestMethod.GET)
    public ModelAndView getSelectedIssue(@RequestParam() String issueKey) {
        ModelAndView model = new ModelAndView();

        System.out.println("-----------------issueKey------------------------");
        System.out.println(issueKey);

        model.setViewName("viewPoker :: selectedIssueFragment");

        Issue selectedIssue = Utilities.getJiraIssueData(atlassianHostRestClients, issueKey);

        model.addObject("selectedIssue", selectedIssue);
        JiraServerInfo jiraServerInfo = Utilities.getJiraServerInfo(atlassianHostRestClients);
        if (jiraServerInfo != null) {
            model.addObject("baseUrl", jiraServerInfo.getBaseUrl());
        }

        return model;
    }
}
