package id.ac.ui.cs.eaap.lab.service;


import id.ac.ui.cs.eaap.lab.model.IssueModel;
import id.ac.ui.cs.eaap.lab.model.RoomModel;
import id.ac.ui.cs.eaap.lab.repository.IssueDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueDB issueDB;

    @Autowired
    private RoomService roomService;

    

    public List<IssueModel> findAll() {
        return issueDB.findAll();
    }

    public List<IssueModel> findAllByRoomId(Long roomId){
        RoomModel room = roomService.getRoomById(roomId);
        return issueDB.findByRoomModel(room);
    }

    public IssueModel getIssueById(Long id){
        return issueDB.findById(id).get();
    }

    public void add(IssueModel issueModel) {
        issueDB.save(issueModel);
    }

    public void update(IssueModel issueModel) {
        IssueModel updatedIssue = getIssueById(issueModel.getIssueId());
        if (updatedIssue != null){
            updatedIssue.setIssueId(issueModel.getIssueId());
            updatedIssue.setDescription(issueModel.getDescription());
            updatedIssue.setReportedBy(issueModel.getReportedBy());
            updatedIssue.setReportedOn(issueModel.getReportedOn());
            updatedIssue.setRoomModel(issueModel.getRoomModel());
            updatedIssue.setStatus(issueModel.getStatus());
            issueDB.save(updatedIssue);
        }
    }

}

