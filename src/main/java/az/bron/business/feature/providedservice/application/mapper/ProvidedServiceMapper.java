package az.bron.business.feature.providedservice.application.mapper;

import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProvidedServiceMapper {
    @Mapping(source = "companyId", target = "company.id")
    ProvidedService toModel(CreateProvidedServiceRequest request);

    @Mapping(source = "companyId", target = "company.id")
    ProvidedService toModel(UpdateProvidedServiceRequest request);

    @Mapping(target = "companyId", source = "company.id")
    CreateProvidedServiceResponse toCreateResponse(ProvidedService providedservice);

    @Mapping(target = "companyId", source = "company.id")
    UpdateProvidedServiceResponse toUpdateResponse(ProvidedService providedservice);

    GetProvidedServiceResponse toGetResponse(ProvidedService providedservice);
}
