package id.ac.ui.cs.eaap.lab;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import id.ac.ui.cs.eaap.lab.model.IssueModel;
import id.ac.ui.cs.eaap.lab.model.RoomModel;
import id.ac.ui.cs.eaap.lab.repository.RoomDB;
import id.ac.ui.cs.eaap.lab.service.IssueService;
import id.ac.ui.cs.eaap.lab.service.RoomService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class ExamMid2023Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamMid2023Application.class, args);
    }

    @Bean
	@Transactional
	CommandLineRunner run(RoomService roomService, IssueService issueService) {
		return args -> {
            // initial data for room
			// RoomModel newRoom = new RoomModel();

            // newRoom.setFaculty("Fasilkom");
            // newRoom.setBuildingName("Gedung A");
            // newRoom.setRoomName("Ruang Tidur");
            // newRoom.setRoomNumber("Z 101");

            // roomService.add(newRoom);
            

            // initial data for issue
            // RoomModel room = roomService.getRoomById(1201L);

            // IssueModel issue = new IssueModel();
            // issue.setDescription("test");
            // issue.setReportedBy("Rudy");
            // issue.setReportedOn(new Date(System.currentTimeMillis()));
            // issue.setStatus("new");
            // issue.setRoomModel(room);

            // issueService.add(issue);
			
		};
	}

}
