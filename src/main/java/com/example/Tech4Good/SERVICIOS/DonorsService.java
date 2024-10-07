package com.example.Tech4Good.SERVICIOS;

import com.example.Tech4Good.MODELOS.Donors;

import java.util.List;

public interface DonorsService {

    public List<Donors> getAllDonors ();

    public Donors getDonorsByIdentificationNumber (String identificationNumber);

    public Donors createDonors (Donors donors);

    public Donors updateDonors (Donors donors);

    public Boolean deleteDonors (String identificationNumber);
}
