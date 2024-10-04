package com.example.Tech4Good.SERVICIOS;

import com.example.Tech4Good.MODELOS.BeneficiaryOrganization;
import com.example.Tech4Good.REPOSITORIOS.BeneficiaryOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryOrganizationImplementation implements BeneficiaryOrganizationService{

    @Autowired
    private BeneficiaryOrganizationRepository beneficiaryOrganizationRepository;

    @Override
    public List<BeneficiaryOrganization> getAllBeneficiaryOrganizations() {
        return beneficiaryOrganizationRepository.findAll();
    }

    @Override
    public BeneficiaryOrganization getBeneficiaryOrganizationsByIdentificationNumber(String identificationNumber) {
        return beneficiaryOrganizationRepository.findByIdentificationNumber(identificationNumber);
    }

    @Override
    public BeneficiaryOrganization createBeneficiaryOrganization(BeneficiaryOrganization beneficiaryOrganization) {
        return beneficiaryOrganizationRepository.save(beneficiaryOrganization);
    }

    @Override
    public BeneficiaryOrganization updateBeneficiaryOrganization(BeneficiaryOrganization beneficiaryOrganization) {
        return beneficiaryOrganizationRepository.save(beneficiaryOrganization); //REVISAR MAS ADELANTE
    }

    @Override
    public Boolean deleteBeneficiaryOrganization(String identificationNumber) {
        try {
            beneficiaryOrganizationRepository.deleteById(beneficiaryOrganizationRepository.findByIdentificationNumber(identificationNumber).getIdOrganization());
            return true;
        } catch (Exception e){
            System.out.println("El error fue " + e);
            return false;
        }
    }
}
