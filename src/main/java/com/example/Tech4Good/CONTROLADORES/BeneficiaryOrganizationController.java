package com.example.Tech4Good.CONTROLADORES;

import com.example.Tech4Good.MODELOS.BeneficiaryOrganization;
import com.example.Tech4Good.SERVICIOS.BeneficiaryOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
@CrossOrigin("http://localhost:1339/")
public class BeneficiaryOrganizationController {

    @Autowired
    private BeneficiaryOrganizationService beneficiaryOrganizationService;

    @GetMapping
    public ResponseEntity<List<BeneficiaryOrganization>> getAllBeneficiaryOrganizations(){
        return new ResponseEntity<>(beneficiaryOrganizationService.getAllBeneficiaryOrganizations(), HttpStatus.OK);
    }

}
