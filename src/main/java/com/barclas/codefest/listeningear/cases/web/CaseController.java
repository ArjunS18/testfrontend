package com.barclas.codefest.listeningear.cases.web;

import com.barclas.codefest.listeningear.cases.dto.Case;
import com.barclas.codefest.listeningear.cases.model.CaseRepository;
import com.barclas.codefest.listeningear.cases.service.CaseService;
import com.barclas.codefest.listeningear.referrals.model.Client;
import com.barclas.codefest.listeningear.referrals.model.Referral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/case")
public class CaseController {

    @Autowired
    private final CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Case createCase(@RequestBody Referral referral) throws Exception {
        return caseService.createCase(referral);
    }

    @GetMapping("/assignDoctor/{caseId}/{doctorId}")
    @ResponseStatus(HttpStatus.CREATED)
    public String assignDoctor( @PathVariable("caseId") Long caseId, @PathVariable("doctorId") Long doctorId)
            throws Exception {
        try {
            caseService.assignDoctor(doctorId, caseId);

            return "Doctor assigned successfully!";
        }
        catch(Exception e){
            throw new Exception(e);
        }
    }

    @GetMapping("/{clientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Case> getCasesOfClient( @PathVariable("clientId") Long clientId)
            throws Exception {

            return caseService.getCasesOfClient(clientId);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Case> getAllClients() {
        try {
            return caseService.getAllCases();
        } catch (Exception ex) {
            return new ArrayList<Case>();
        }
    }


}
