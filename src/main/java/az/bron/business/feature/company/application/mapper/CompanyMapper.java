package az.bron.business.feature.company.application.mapper;

import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.contact.application.mapper.ContactMapper;
import az.bron.business.feature.master.application.mapper.MasterMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {ContactMapper.class, MasterMapper.class})
public interface CompanyMapper {
    @Mapping(source = "contactId", target = "contact.id")
    Company toModel(CreateCompanyRequest request);

    @Mapping(source = "contactId", target = "contact.id")
    Company toModel(UpdateCompanyRequest request);

    @Mapping(target = "contactId", source = "contact.id")
    CreateCompanyResponse toCreateResponse(Company company);

    @Mapping(target = "contactId", source = "contact.id")
    UpdateCompanyResponse toUpdateResponse(Company company);


    @Mapping(target = "providedServices.masters", ignore = true)
    @Mapping(target = "masters.masterServices", ignore = true)
    GetCompanyResponse toGetResponse(Company company);
}
