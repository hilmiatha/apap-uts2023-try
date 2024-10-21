package id.ac.ui.cs.eaap.lab.restDTO.response;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponseDTO<T> {
    private int status;
    private String message;

    private Date timestamp;
    
    private T data;
    
}
