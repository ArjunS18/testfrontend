package com.barclas.codefest.listeningear.referrals.dto;

import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.referrals.model.Client;

import javax.persistence.*;
import java.sql.Timestamp;

public class ReferralDto {

    private Integer referralId;

    private String firstName;

    private String surname;

    private String dob;

    private String address1;

    private String address2;

    private String phoneNo;

    private String status;

    private String gpSurgeryName;

    private String gpSurgeryAddress;

    private String gpSurgeryPhoneNo;

    private Timestamp lastUpdated;

    private Timestamp createdTime;

    private Case caseHistory;

    private Client client;

    public Integer getReferralId() {
        return referralId;
    }

    public void setReferralId(Integer referralId) {
        this.referralId = referralId;
    }

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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGpSurgeryName() {
        return gpSurgeryName;
    }

    public void setGpSurgeryName(String gpSurgeryName) {
        this.gpSurgeryName = gpSurgeryName;
    }

    public String getGpSurgeryAddress() {
        return gpSurgeryAddress;
    }

    public void setGpSurgeryAddress(String gpSurgeryAddress) {
        this.gpSurgeryAddress = gpSurgeryAddress;
    }

    public String getGpSurgeryPhoneNo() {
        return gpSurgeryPhoneNo;
    }

    public void setGpSurgeryPhoneNo(String gpSurgeryPhoneNo) {
        this.gpSurgeryPhoneNo = gpSurgeryPhoneNo;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Case getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(Case caseHistory) {
        this.caseHistory = caseHistory;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
