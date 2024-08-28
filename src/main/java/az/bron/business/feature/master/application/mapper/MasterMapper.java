package az.bron.business.feature.master.application.mapper;

import az.bron.business.feature.master.application.model.request.CreateMasterRequest;
import az.bron.business.feature.master.application.model.request.UpdateMasterRequest;
import az.bron.business.feature.master.application.model.response.CreateMasterResponse;
import az.bron.business.feature.master.application.model.response.GetMasterResponse;
import az.bron.business.feature.master.application.model.response.UpdateMasterResponse;
import az.bron.business.feature.master.domain.model.Master;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MasterMapper {
    Master toModel(CreateMasterRequest request);

    Master toModel(UpdateMasterRequest request);

    CreateMasterResponse toCreateResponse(Master master);

    UpdateMasterResponse toUpdateResponse(Master master);

    GetMasterResponse toGetResponse(Master master);
}
