package az.bron.business.feature.masterprovidedservice.application.mapper;

import az.bron.business.feature.masterprovidedservice.application.model.request.CreateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.request.UpdateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.response.CreateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetCertainProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.UpdateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MasterProvidedServiceMapper {
    @Mapping(source = "masterId", target = "master.id")
    @Mapping(source = "serviceId", target = "providedService.id")
    MasterProvidedService toModel(CreateMasterProvidedServiceRequest request);

    @Mapping(source = "masterId", target = "master.id")
    @Mapping(source = "serviceId", target = "providedService.id")
    MasterProvidedService toModel(UpdateMasterProvidedServiceRequest request);

    @Mapping(target = "masterId", source = "master.id")
    @Mapping(target = "serviceId", source = "providedService.id")
    CreateMasterProvidedServiceResponse toCreateResponse(MasterProvidedService masterprovidedservice);

    @Mapping(target = "masterId", source = "master.id")
    @Mapping(target = "serviceId", source = "providedService.id")
    UpdateMasterProvidedServiceResponse toUpdateResponse(MasterProvidedService masterprovidedservice);

    @Mapping(target = "masterId", source = "master.id")
    @Mapping(target = "serviceId", source = "providedService.id")
    GetMasterProvidedServiceResponse toGetResponse(MasterProvidedService masterprovidedservice);

    @Mapping(target = "id", source = "providedService.id")
    @Mapping(target = "name", source = "providedService.name")
    @Mapping(target = "description", source = "providedService.description")
    @Mapping(target = "duration", source = "providedService.duration")
    @Mapping(target = "companyId", source = "providedService.company.id")
    GetCertainProvidedServiceResponse toGetCertainResponse(MasterProvidedService masterprovidedservice);
}
