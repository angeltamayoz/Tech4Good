package com.example.Tech4Good.SERVICIOS;

import com.example.Tech4Good.MODELOS.Donors;
import com.example.Tech4Good.REPOSITORIOS.DonorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorsImplementation implements DonorsService{

    @Autowired
    private DonorsRepository donorsRepository;

    @Override
    public List<Donors> getAllDonors() {
        return donorsRepository.findAll();
    }

    @Override
    public Donors getDonorsByIdentificationNumber(String identificationNumber) {
        return donorsRepository.findByIdentificationNumber(identificationNumber);
    }

    @Override
    public Donors createDonors(Donors donors) {
        return donorsRepository.save(donors);
    }

    @Override
    public Donors updateDonors(Donors donors) {
        return donorsRepository.save(donors);
    }

    @Override
    public Boolean deleteDonors(String identificationNumber) {
        try {
            donorsRepository.deleteById(donorsRepository.findByIdentificationNumber(identificationNumber).getIdDonor());
            return true;
        } catch (Exception e){
            System.out.println("El error fue " + e);
            return false;
        }
    }
}