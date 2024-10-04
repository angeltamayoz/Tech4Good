package com.example.Tech4Good.REPOSITORIOS;

import com.example.Tech4Good.MODELOS.BeneficiaryOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaryOrganizationRepository extends JpaRepository <BeneficiaryOrganization, Long> {
    BeneficiaryOrganization findByIdentificationNumber (String identificationNumber);
}
