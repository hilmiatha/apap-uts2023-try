package id.ac.ui.cs.eaap.lab.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddRoomRequestDTO {

    private Long roomId;

    @NotBlank(message = "Nomor ruangan tidak boleh kosong!")
    private String roomNumber;

    @NotBlank(message = "Nama ruangan tidak boleh kosong!")
    private String roomName;

    @NotBlank(message = "Nama gedung tidak boleh kosong!")
    private String buildingName;
    
    @NotBlank(message = "Fakultas tidak boleh kosong!")
    private String faculty;

    
}
