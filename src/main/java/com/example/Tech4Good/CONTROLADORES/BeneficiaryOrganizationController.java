package com.example.Tech4Good.CONTROLADORES;

import com.example.Tech4Good.MODELOS.BeneficiaryOrganization;
import com.example.Tech4Good.SERVICIOS.BeneficiaryOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiarios")
@CrossOrigin("https://zorany26.github.io")
public class BeneficiaryOrganizationController {

    @Autowired
    private BeneficiaryOrganizationService beneficiaryOrganizationService;

    @GetMapping
    public ResponseEntity<List<BeneficiaryOrganization>> getAllBeneficiaryOrganizations(){
        return new ResponseEntity<>(beneficiaryOrganizationService.getAllBeneficiaryOrganizations(), HttpStatus.OK);
    }

    @GetMapping("/{identificationNumber}")
    public ResponseEntity<BeneficiaryOrganization> getBeneficiaryOrganizationsByIdentificationNumber(@PathVariable String identificationNumber){
        try {
            return new ResponseEntity<BeneficiaryOrganization>(beneficiaryOrganizationService.getBeneficiaryOrganizationsByIdentificationNumber(identificationNumber), HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Se produjo un error " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BeneficiaryOrganization> createBeneficiaryOrganization (@RequestBody BeneficiaryOrganization beneficiaryOrganization){
        return new ResponseEntity<BeneficiaryOrganization>(beneficiaryOrganizationService.createBeneficiaryOrganization(beneficiaryOrganization), HttpStatus.CREATED);
    }

    @PutMapping("/{identificationNumber}")
    public ResponseEntity<?> updateBeneficiaryOrganization (@RequestBody BeneficiaryOrganization beneficiaryOrganization, @PathVariable String identificationNumber){
        try{
            BeneficiaryOrganization currentBeneficiaryOrganization = beneficiaryOrganizationService.getBeneficiaryOrganizationsByIdentificationNumber(identificationNumber);

            currentBeneficiaryOrganization.setIdentificationNumber(beneficiaryOrganization.getIdentificationNumber());
            currentBeneficiaryOrganization.setNameOrganization(beneficiaryOrganization.getNameOrganization());
            currentBeneficiaryOrganization.setEmail(beneficiaryOrganization.getEmail());
            currentBeneficiaryOrganization.setPhoneNumber(beneficiaryOrganization.getPhoneNumber());
            currentBeneficiaryOrganization.setAddressOrganization(beneficiaryOrganization.getAddressOrganization());
            currentBeneficiaryOrganization.setCity(beneficiaryOrganization.getCity());
            currentBeneficiaryOrganization.setOrganizationType(beneficiaryOrganization.getOrganizationType());
            currentBeneficiaryOrganization.setContactPerson(beneficiaryOrganization.getContactPerson());

            beneficiaryOrganizationService.updateBeneficiaryOrganization(currentBeneficiaryOrganization);
            return new ResponseEntity<BeneficiaryOrganization>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println("Se produjo un error " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{identificationNumber}")
    public ResponseEntity<?> deleteBeneficiaryOrganization (@PathVariable String identificationNumber){
        try{
            if(beneficiaryOrganizationService.getBeneficiaryOrganizationsByIdentificationNumber(identificationNumber) != null){
                if(beneficiaryOrganizationService.deleteBeneficiaryOrganization(identificationNumber)){
                    return new ResponseEntity<>(HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e) {
            System.out.println("Se produjo un error " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
