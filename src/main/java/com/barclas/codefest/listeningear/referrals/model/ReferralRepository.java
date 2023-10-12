package com.barclas.codefest.listeningear.referrals.model;

import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.referrals.model.Referral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReferralRepository extends JpaRepository<Referral, Long> {
    List findAll();
    List<Referral> findAllReferralsByStatus(String status);
    Referral findByReferralId(Long referralId);
}
