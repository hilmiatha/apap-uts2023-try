package id.ac.ui.cs.eaap.lab.repository;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.eaap.lab.model.RoomModel;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoomDB extends JpaRepository<RoomModel, Long>{
    
}
