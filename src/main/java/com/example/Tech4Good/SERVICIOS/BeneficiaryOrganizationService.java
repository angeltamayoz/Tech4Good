package com.example.Tech4Good.SERVICIOS;

import com.example.Tech4Good.MODELOS.BeneficiaryOrganization;

import java.util.List;

public interface BeneficiaryOrganizationService {
    //Consultar todos los beneficiarios
    public List<BeneficiaryOrganization> getAllBeneficiaryOrganizations ();

    //Consultar beneficiario por identification
    public BeneficiaryOrganization getBeneficiaryOrganizationsByIdentificationNumber (String identificationNumber);

    //Crear registro de beneficiarios
    public BeneficiaryOrganization createBeneficiaryOrganization (BeneficiaryOrganization beneficiaryOrganization);

    //Actualizar registro beneficiario
    public BeneficiaryOrganization updateBeneficiaryOrganization (BeneficiaryOrganization beneficiaryOrganization);

    //Eliminar beneficiario
    public Boolean deleteBeneficiaryOrganization (String identificationNumber);
}
