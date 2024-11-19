package az.bron.business.feature.providedservice.application.facade;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.feature.providedservice.application.SortProvidedServiceBy;
import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.specification.ProvidedServiceFilter;
import java.io.IOException;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface ProvidedServiceFacade {
    CreateProvidedServiceResponse create(CreateProvidedServiceRequest request);

    UpdateProvidedServiceResponse update(Long id, UpdateProvidedServiceRequest request);

    GetProvidedServiceResponse get(Long id);

    Page<GetProvidedServiceResponse> getAll(int page, int size, SortProvidedServiceBy sortBy, SortDirection sortDir,
                                            ProvidedServiceFilter filter);

    void delete(Long id);

    void uploadCoverImage(Long id, MultipartFile file) throws IOException;
}
