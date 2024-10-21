package id.ac.ui.cs.eaap.lab.restDTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomResponseDTO {
    private long roomId;
   
    private String roomNumber;
   
    private String roomName;
 
    private String buildingName;

    private String faculty;

}
