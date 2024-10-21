package id.ac.ui.cs.eaap.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.eaap.lab.model.IssueModel;
import id.ac.ui.cs.eaap.lab.model.RoomModel;

@Repository
public interface IssueDB extends JpaRepository<IssueModel, Long> {
    
    List<IssueModel> findByRoomModel(RoomModel room); 

}
