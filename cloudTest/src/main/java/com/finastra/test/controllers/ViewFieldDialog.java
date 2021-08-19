package com.finastra.test.controllers;

import com.atlassian.connect.spring.AtlassianHostRestClients;
import com.atlassian.connect.spring.ContextJwt;
import com.finastra.test.Utilities;
import com.finastra.test.models.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewFieldDialog {

    @Autowired
    private AtlassianHostRestClients atlassianHostRestClients;

    @RequestMapping(value = "/viewFieldValueDialog", method = RequestMethod.GET)
    public ModelAndView getFieldValueSetup() {
        ModelAndView model = new ModelAndView();

        model.setViewName("viewFieldDialog");

        model.addObject("issue", new Issue());

        return model;
    }

    @ContextJwt
    @RequestMapping(value = "/viewFieldValueDialog", method = RequestMethod.POST)
    public String setFieldValueSetup(@ModelAttribute Issue issue, Model model) {

        Issue issueData = Utilities.getJiraIssueData(atlassianHostRestClients, issue.getKey());

        if (issueData == null) {
            model.addAttribute("error", "Issue does not exist or you do not have permission to see it!");
            model.addAttribute("hasError", true);
        }

        if (issueData != null) {
            model.addAttribute("issue", issueData);
        } else {
            model.addAttribute("issue", new Issue());
        }

        return "viewFieldDialog";
    }
}
