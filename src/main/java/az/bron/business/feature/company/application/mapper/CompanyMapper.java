package az.bron.business.feature.company.application.mapper;

import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Company toModel(CreateCompanyRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    Company toModel(UpdateCompanyRequest request);

    CreateCompanyResponse toCreateResponse(Company company);

    UpdateCompanyResponse toUpdateResponse(Company company);

    GetCompanyResponse toVehicleResponse(Company company);
}