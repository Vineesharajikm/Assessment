package com.ikm.Assessment.contract;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ApplicantDetailDTO {

    private Integer id;

    private String applicantName;

    private Integer appliacntAge;

}
