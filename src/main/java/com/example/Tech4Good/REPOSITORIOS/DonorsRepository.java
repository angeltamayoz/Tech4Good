package com.example.Tech4Good.REPOSITORIOS;

import com.example.Tech4Good.MODELOS.Donors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorsRepository extends JpaRepository <Donors, Long> {
    Donors findByIdentificationNumber (String identificationNumber);
}
