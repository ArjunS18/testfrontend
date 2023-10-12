package com.barclas.codefest.listeningear.cases.dto;

import com.barclas.codefest.listeningear.home.model.User;
import com.barclas.codefest.listeningear.referrals.model.Client;
import com.barclas.codefest.listeningear.referrals.model.Referral;
import javax.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cases",schema = "spartans")
public class Case {

    @Id
    @Column(name = "caseId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    private Client client;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "referralId", referencedColumnName = "referralId")
    private Referral referral;

    @Column(name = "creationDate")
    private Timestamp creationDate;

    @Column(name = "status")
    private String status;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctorId", referencedColumnName = "userId")
    private User doctor;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }
}
