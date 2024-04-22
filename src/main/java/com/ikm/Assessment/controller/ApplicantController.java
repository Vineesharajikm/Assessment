package com.ikm.Assessment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ikm.Assessment.contract.ApplicantDetailDTO;
import com.ikm.Assessment.contract.Response;
import com.ikm.Assessment.model.ApplicantDetail;
import com.ikm.Assessment.service.ApplicantService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApplicantController {

    private final ApplicantService service;

    @PostMapping("save")
    public Object saveApplicantBasicData(@RequestBody ApplicantDetailDTO request) {

        Object data = service.saveApplicantBasicData(request);
        return data;
    }


    @GetMapping("/filterBy")
    public ResponseEntity<Response<List<ApplicantDetailDTO>>> getApplicatantAgeBetween(
            @RequestParam("fromAge") Integer fromAge,
            @RequestParam("toAge") Integer toAge) {
        List<ApplicantDetailDTO> response = service.FilterByAge(fromAge, toAge);
        if (response != null) {
            return new ResponseEntity<>(
                    Response.<List<ApplicantDetailDTO>>builder()
                            .payload(response)
                            .message("Saved Successfully.")
                            .build(),
                    HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

@GetMapping("/above50Age")
    public List<ApplicantDetail> getSalariesBelowFifty(@RequestParam Integer age) {
        return service.getAgeBelowifty(age);
    }

    @GetMapping("/Equal50Age")
    public List<ApplicantDetail> getSalariesEqualFifty(@RequestParam Integer age) {
        return service.getAgeEqualFifty(age);
    }
}
