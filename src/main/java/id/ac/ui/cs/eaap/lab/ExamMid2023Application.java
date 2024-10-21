package id.ac.ui.cs.eaap.lab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import id.ac.ui.cs.eaap.lab.model.RoomModel;
import id.ac.ui.cs.eaap.lab.repository.RoomDB;
import id.ac.ui.cs.eaap.lab.service.RoomService;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class ExamMid2023Application {

    public static void main(String[] args) {
        SpringApplication.run(ExamMid2023Application.class, args);
    }

    @Bean
	@Transactional
	CommandLineRunner run(RoomService roomService) {
		return args -> {
			// RoomModel newRoom = new RoomModel();

            // newRoom.setFaculty("Fasilkom");
            // newRoom.setBuildingName("Gedung A");
            // newRoom.setRoomName("Ruang Tidur");
            // newRoom.setRoomNumber("Z 101");

            // roomService.add(newRoom);
			
		};
	}

}
