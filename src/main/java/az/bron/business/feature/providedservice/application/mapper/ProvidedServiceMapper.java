package az.bron.business.feature.providedservice.application.mapper;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.ProvidedServiceFilterRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.specification.ProvidedServiceFilter;
import az.bron.business.feature.staff.application.mapper.StaffMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = StaffMapper.class)
public interface ProvidedServiceMapper {
    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "categoryId", target = "category.id")
    ProvidedService toModel(CreateProvidedServiceRequest request);

    @Mapping(source = "companyId", target = "company.id")
    ProvidedService toModel(UpdateProvidedServiceRequest request);

    @Mapping(target = "companyId", source = "company.id")
    CreateProvidedServiceResponse toCreateResponse(ProvidedService providedservice);

    @Mapping(target = "companyId", source = "company.id")
    UpdateProvidedServiceResponse toUpdateResponse(ProvidedService providedservice);

    GetProvidedServiceResponse toGetResponse(ProvidedService providedservice);

    ProvidedServiceFilter toFilter(ProvidedServiceFilterRequest filter);

}
