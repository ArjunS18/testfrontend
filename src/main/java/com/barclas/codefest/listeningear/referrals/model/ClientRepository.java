package com.barclas.codefest.listeningear.referrals.model;

import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.referrals.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    int countByClientId(String clientId);
    Client findByClientId(Long clientId);
}
