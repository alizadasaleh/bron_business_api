package az.bron.business.feature.master.application.mapper;

import az.bron.business.feature.master.application.model.request.CreateMasterRequest;
import az.bron.business.feature.master.application.model.request.UpdateMasterRequest;
import az.bron.business.feature.master.application.model.response.CreateMasterResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.master.application.model.response.UpdateMasterResponse;
import az.bron.business.feature.master.domain.model.Master;
import az.bron.business.feature.masterprovidedservice.application.mapper.MasterProvidedServiceMapper;
import az.bron.business.feature.providedservice.application.mapper.ProvidedServiceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {MasterProvidedServiceMapper.class, ProvidedServiceMapper.class})
public interface MasterMapper {
    @Mapping(source = "companyId", target = "company.id")
    Master toModel(CreateMasterRequest request);

    @Mapping(source = "companyId", target = "company.id")
    Master toModel(UpdateMasterRequest request);

    @Mapping(target = "companyId", source = "company.id")
    CreateMasterResponse toCreateResponse(Master master);

    @Mapping(target = "companyId", source = "company.id")
    UpdateMasterResponse toUpdateResponse(Master master);

    @Mapping(source = "masterServices", target = "services")
    GetMasterResponse toGetResponse(Master master);

}
