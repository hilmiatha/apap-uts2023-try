package id.ac.ui.cs.eaap.lab.controller;


import id.ac.ui.cs.eaap.lab.restDTO.response.BaseResponseDTO;
import id.ac.ui.cs.eaap.lab.restDTO.response.IssueResponseDTO;
import id.ac.ui.cs.eaap.lab.restservice.IssueRestService;
import id.ac.ui.cs.eaap.lab.restservice.ReportRestService;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/lapor")
public class IssueRestController {

    @Autowired
    IssueRestService issueRestService;

    @Autowired
    ReportRestService reportRestService;


    @GetMapping("/active")
    public ResponseEntity<?> getAllActiveIssues(){
        var baseResponseDTO = new BaseResponseDTO<List<IssueResponseDTO>>();

        List<IssueResponseDTO> listActiveIssues = issueRestService.getAllActiveIssues();

        if (listActiveIssues == null){
            baseResponseDTO.setStatus(HttpStatus.NOT_FOUND.value());
            baseResponseDTO.setMessage(String.format("Something Wrong"));
            baseResponseDTO.setTimestamp(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(baseResponseDTO, HttpStatus.NOT_FOUND);
        }
        baseResponseDTO.setStatus(HttpStatus.OK.value());
        baseResponseDTO.setData(listActiveIssues);
        baseResponseDTO.setMessage(String.format("Issues Retrieved Successfully"));
        baseResponseDTO.setTimestamp(new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
        
    }

    @GetMapping("/statistics")
    public ResponseEntity<?> getStatisticsIssues() {
        log.info("api statistics");
        // TODO
        var baseResponseDTO = new BaseResponseDTO<Map<String,Long>>();

        Map<String,Long> map = reportRestService.getActiveIssuesCounts();

        if (map == null){
            baseResponseDTO.setStatus(HttpStatus.NOT_FOUND.value());
            baseResponseDTO.setMessage(String.format("Something Wrong"));
            baseResponseDTO.setTimestamp(new Date(System.currentTimeMillis()));
            return new ResponseEntity<>(baseResponseDTO, HttpStatus.NOT_FOUND);
        }
        baseResponseDTO.setStatus(HttpStatus.OK.value());
        baseResponseDTO.setData(map);
        baseResponseDTO.setMessage(String.format("Issues Retrieved Successfully"));
        baseResponseDTO.setTimestamp(new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(baseResponseDTO, HttpStatus.OK);
    }
}
