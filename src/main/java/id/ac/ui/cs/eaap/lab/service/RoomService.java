package id.ac.ui.cs.eaap.lab.service;


import id.ac.ui.cs.eaap.lab.model.RoomModel;
import id.ac.ui.cs.eaap.lab.repository.RoomDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomDB roomDB;

    public List<RoomModel> findAll() {
        return roomDB.findAll();
    }

    public void add(RoomModel roomModel) {
        roomDB.save(roomModel);
    }

    public void update(RoomModel roomModel) {
    }
}

