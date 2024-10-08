package com.example.Tech4Good.CONTROLADORES;

import com.example.Tech4Good.MODELOS.Donors;
import com.example.Tech4Good.SERVICIOS.DonorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donantes")
@CrossOrigin("https://zorany26.github.io")
public class DonorsController {
    @Autowired
    private DonorsService donorsService;

    @GetMapping
    public ResponseEntity<List<Donors>> getAllDonors(){
        return new ResponseEntity<>(donorsService.getAllDonors(), HttpStatus.OK);
    }

    @GetMapping("/{identificationNumber}")
    public ResponseEntity<Donors> getDonorsByIdentificationNumber(@PathVariable String identificationNumber){
        try {
            return new ResponseEntity<Donors>(donorsService.getDonorsByIdentificationNumber(identificationNumber), HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Se produjo un error " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Donors> createDonors (@RequestBody Donors donors){
        return new ResponseEntity<Donors>(donorsService.createDonors(donors), HttpStatus.CREATED);
    }

    @PutMapping("/{identificationNumber}")
    public ResponseEntity<?> updateDonors (@RequestBody Donors donors, @PathVariable String identificationNumber){
        try{
            Donors currentDonors = donorsService.getDonorsByIdentificationNumber(identificationNumber);

            currentDonors.setIdentificationNumber(donors.getIdentificationNumber());
            currentDonors.setNameDonor(donors.getNameDonor());
            currentDonors.setEmail(donors.getEmail());
            currentDonors.setPhoneNumber(donors.getPhoneNumber());
            currentDonors.setCity(donors.getCity());
            currentDonors.setDonorType(donors.getDonorType());
            currentDonors.setAddressDonor(donors.getAddressDonor());

            donorsService.updateDonors(currentDonors);
            return new ResponseEntity<Donors>(HttpStatus.OK);
        }catch(Exception e){
            System.out.println("Se produjo un error " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{identificationNumber}")
    public ResponseEntity<?> deleteDonors (@PathVariable String identificationNumber){
        try{
            if(donorsService.getDonorsByIdentificationNumber(identificationNumber) != null){
                if(donorsService.deleteDonors(identificationNumber)){
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
