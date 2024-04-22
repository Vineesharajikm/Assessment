package com.ikm.Assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikm.Assessment.model.ApplicantDetail;
import java.util.List;


public interface ApplicantRepository extends JpaRepository <ApplicantDetail, Integer> {

  List<ApplicantDetail>  findByApplicantAgeBetween(Integer fromAge,Integer toAge );
  List<ApplicantDetail> findByApplicantAgeLessThan(Integer age);
  List<ApplicantDetail> findByApplicantAgeEquals(Integer age);
}
