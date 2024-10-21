package id.ac.ui.cs.eaap.lab.restDTO.response;

import java.sql.Date;


import com.fasterxml.jackson.annotation.JsonInclude;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IssueResponseDTO {
    private long issueId;

    private String description;

    private String reportedBy;

 
    private Date reportedOn;

    private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RoomResponseDTO room;

    private Long unresolvedDays;
}
