package id.ac.ui.cs.eaap.lab.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.ac.ui.cs.eaap.lab.model.IssueModel;
import id.ac.ui.cs.eaap.lab.service.IssueService;

@Slf4j
@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    IssueService issueService;
    
    @GetMapping(value = "/active")
    public String viewActiveIssueCase(Model model) {
        List<IssueModel> listIssues = issueService.findAll();
        ArrayList<IssueModel> filteredIssues = new ArrayList<>();
        for (IssueModel issue : listIssues){
            if (!issue.getStatus().equals("done")){
                filteredIssues.add(issue);
            }
        }
        model.addAttribute("filteredIssues", filteredIssues);
        return "report/report-active-issues";
    }

    @GetMapping(value = "/statistics")
    public String viewStatistics(Model model) {
        return "report/report-statistics";
    }

}
