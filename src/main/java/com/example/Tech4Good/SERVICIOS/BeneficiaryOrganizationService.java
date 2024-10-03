package com.example.Tech4Good.SERVICIOS;

import com.example.Tech4Good.MODELOS.BeneficiaryOrganization;

import java.util.List;

public interface BeneficiaryOrganizationService {
    //Consultar todos los beneficiarios
    public List<BeneficiaryOrganization> getAllBeneficiaryOrganizations ();

    //Crear registro de beneficiarios
    public BeneficiaryOrganization createBeneficiaryOrganization (BeneficiaryOrganization beneficiaryOrganization);

    //Actualizar registro beneficiario
    public BeneficiaryOrganization updateBeneficiaryOrganization (BeneficiaryOrganization beneficiaryOrganization);

    //Eliminar beneficiario
    public Boolean deleteBeneficiaryOrganization (Long idOrganization);
}
