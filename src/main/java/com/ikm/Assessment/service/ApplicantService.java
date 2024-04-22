package com.ikm.Assessment.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ikm.Assessment.config.MapperConfig;
import com.ikm.Assessment.contract.ApplicantDetailDTO;
import com.ikm.Assessment.model.ApplicantDetail;
import com.ikm.Assessment.repository.ApplicantRepository;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class ApplicantService {
    private final ApplicantRepository repo;

    ModelMapper mapper = new ModelMapper();

    public Object saveApplicantBasicData(ApplicantDetailDTO request) {

        ApplicantDetail model = mapper.map(request, ApplicantDetail.class);
        return repo.save(model);

    }

    public List<ApplicantDetailDTO> FilterByAge(Integer fromDate, Integer toDate) {
        List<ApplicantDetail> details = repo.findByApplicantAgeBetween(fromDate, toDate);
        List<ApplicantDetailDTO> responseList = null;
        responseList = details.stream()
                .map(
                        registerBook -> mapper.map(
                                registerBook, ApplicantDetailDTO.class))
                .collect(Collectors.toList());
        return responseList;
    }

    public List<ApplicantDetail> getAgeBelowifty(Integer age) {

        return repo.findByApplicantAgeLessThan(age);
    }

    public List<ApplicantDetail> getAgeEqualFifty(Integer age) {

        return repo.findByApplicantAgeLessThan(age);
    }

}
