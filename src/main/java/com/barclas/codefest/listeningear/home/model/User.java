package com.barclas.codefest.listeningear.home.model;

import com.barclas.codefest.listeningear.cases.dto.Case;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "user",schema = "spartans")
public class User {

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    @Id
    @Column(name = "userid")
    private Long userid;

    @OneToOne(mappedBy = "doctor")
    private Case assignedCase;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Case getAssignedCase() {
        return assignedCase;
    }

    public void setAssignedCase(Case assignedCase) {
        this.assignedCase = assignedCase;
    }
}