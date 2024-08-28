package az.bron.business.feature.masterprovidedservice.application.mapper;

import az.bron.business.feature.masterprovidedservice.application.model.request.CreateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.request.UpdateMasterProvidedServiceRequest;
import az.bron.business.feature.masterprovidedservice.application.model.response.CreateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.GetMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.application.model.response.UpdateMasterProvidedServiceResponse;
import az.bron.business.feature.masterprovidedservice.domain.model.MasterProvidedService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MasterProvidedServiceMapper {
    MasterProvidedService toModel(CreateMasterProvidedServiceRequest request);

    MasterProvidedService toModel(UpdateMasterProvidedServiceRequest request);

    CreateMasterProvidedServiceResponse toCreateResponse(MasterProvidedService masterprovidedservice);

    UpdateMasterProvidedServiceResponse toUpdateResponse(MasterProvidedService masterprovidedservice);

    GetMasterProvidedServiceResponse toGetResponse(MasterProvidedService masterprovidedservice);
}
