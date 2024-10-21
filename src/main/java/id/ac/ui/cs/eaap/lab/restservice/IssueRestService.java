package id.ac.ui.cs.eaap.lab.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.eaap.lab.model.IssueModel;
import id.ac.ui.cs.eaap.lab.repository.IssueDB;
import id.ac.ui.cs.eaap.lab.restDTO.response.IssueResponseDTO;
import id.ac.ui.cs.eaap.lab.restDTO.response.RoomResponseDTO;

@Service
public class IssueRestService {

    @Autowired
    private IssueDB issueDB;

    public List<IssueResponseDTO> getAllActiveIssues(){
        var listIssue = issueDB.findAll();
        var filteredIssues = new ArrayList<IssueResponseDTO>();

        for (IssueModel issue : listIssue){
            if (!issue.getStatus().equals("done")){
                var IssueResponseDTO = issueToIssueResponseDTO(issue);
                filteredIssues.add(IssueResponseDTO);
            }
        }
        return filteredIssues;
    }

    private IssueResponseDTO issueToIssueResponseDTO(IssueModel issue) {
        var issueResponseDTO = new IssueResponseDTO();
        issueResponseDTO.setIssueId(issue.getIssueId());
        issueResponseDTO.setDescription(issue.getDescription());
        issueResponseDTO.setReportedBy(issue.getReportedBy());
        issueResponseDTO.setReportedOn(issue.getReportedOn());
        issueResponseDTO.setUnresolvedDays(issue.getUnresolvedDays());
        issueResponseDTO.setStatus(issue.getStatus());
        if (issue.getRoomModel() != null){
            var roomResponseDTO = new RoomResponseDTO();
            var room = issue.getRoomModel();
            roomResponseDTO.setRoomId(room.getRoomId());
            roomResponseDTO.setBuildingName(room.getBuildingName());
            roomResponseDTO.setFaculty(room.getFaculty());
            roomResponseDTO.setRoomName(room.getRoomName());
            roomResponseDTO.setRoomNumber(room.getRoomNumber());
            issueResponseDTO.setRoom(roomResponseDTO);
        }
        return issueResponseDTO;
    }
}
