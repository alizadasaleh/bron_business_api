package az.bron.business.feature.company.application.mapper;

import az.bron.business.feature.address.application.mapper.AddressMapper;
import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.model.Company;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface CompanyMapper {
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "contact.id", source = "contactId")
    Company toModel(CreateCompanyRequest request);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "contact.id", source = "contactId")
    Company toModel(UpdateCompanyRequest request);

    @Mapping(target = "contactId", source = "contact.id")
    CreateCompanyResponse toCreateResponse(Company company);

    @Mapping(target = "contactId", source = "contact.id")
    UpdateCompanyResponse toUpdateResponse(Company company);

    GetCompanyResponse toVehicleResponse(Company company);
}