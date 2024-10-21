package id.ac.ui.cs.eaap.lab.restservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.lab.model.IssueModel;
import id.ac.ui.cs.eaap.lab.repository.IssueDB;

@Service
public class ReportRestService {

    @Autowired
    IssueDB issueDB;

    public List<IssueModel> getActiveIssues(){
        var listIssues = issueDB.findAll();
        List<IssueModel> activeIssues = new ArrayList<>();
        for (IssueModel issue : listIssues){
            if (!issue.getStatus().equals("done")){activeIssues.add(issue);}
        }
        return activeIssues;
    }

    public Map<String,Long> getActiveIssuesCounts(){
        HashMap<String,Long> mapHelper = new HashMap<>();
        for (IssueModel issue : getActiveIssues()){
            if (mapHelper.containsKey(issue.getRoomModel().getFaculty())){ 
                var currentCount = mapHelper.get(issue.getRoomModel().getFaculty());
                mapHelper.put(issue.getRoomModel().getFaculty(), currentCount + 1);
            }else{
                mapHelper.put(issue.getRoomModel().getFaculty(), 1L);
            }
        }
        return mapHelper;
    }
    
}
