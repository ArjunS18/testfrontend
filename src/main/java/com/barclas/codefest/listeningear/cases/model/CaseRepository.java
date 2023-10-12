package com.barclas.codefest.listeningear.cases.model;

import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.cases.dto.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case, Long> {

    @Query("select c from Case c where c.client.clientId = :id")
    List<Case> findAllCasesByClientId(@Param("id") Long id);

    Case findByCaseId(Long caseId);
}
