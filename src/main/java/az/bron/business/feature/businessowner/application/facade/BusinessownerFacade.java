package az.bron.business.feature.businessowner.application.facade;

import az.bron.business.feature.businessowner.application.model.request.CreateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.request.UpdateBusinessownerRequest;
import az.bron.business.feature.businessowner.application.model.response.CreateBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.GetBusinessownerResponse;
import az.bron.business.feature.businessowner.application.model.response.UpdateBusinessownerResponse;

import java.util.List;

public interface BusinessownerFacade {
    CreateBusinessownerResponse create(CreateBusinessownerRequest dto);

    UpdateBusinessownerResponse update(Long id, UpdateBusinessownerRequest dto);

    List<GetBusinessownerResponse> getAll();

    GetBusinessownerResponse get(Long id);

    void delete(Long id);
}
