package az.bron.business.feature.providedservice.application.facade.impl;

import az.bron.business.common.application.model.request.SortDirection;
import az.bron.business.config.S3Service;
import az.bron.business.feature.company.application.exception.CompanyNotFoundException;
import az.bron.business.feature.company.domain.service.CompanyService;
import az.bron.business.feature.providedservice.application.SortProvidedServiceBy;
import az.bron.business.feature.providedservice.application.exception.ProvidedServiceNotFoundException;
import az.bron.business.feature.providedservice.application.facade.ProvidedServiceFacade;
import az.bron.business.feature.providedservice.application.mapper.ProvidedServiceMapper;
import az.bron.business.feature.providedservice.application.model.request.CreateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.request.UpdateProvidedServiceRequest;
import az.bron.business.feature.providedservice.application.model.response.CreateProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.GetProvidedServiceResponse;
import az.bron.business.feature.providedservice.application.model.response.UpdateProvidedServiceResponse;
import az.bron.business.feature.providedservice.domain.model.ProvidedService;
import az.bron.business.feature.providedservice.domain.service.ProvidedServiceService;
import az.bron.business.feature.providedservice.domain.specification.ProvidedServiceFilter;
import az.bron.business.feature.servicecategory.application.exception.ServiceCategoryNotFoundException;
import az.bron.business.feature.servicecategory.domain.service.ServiceCategoryService;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service
@RequiredArgsConstructor
public class ProvidedServiceFacadeImpl implements ProvidedServiceFacade {
    private final ProvidedServiceService providedserviceService;
    private final ProvidedServiceMapper providedserviceMapper;
    private final S3Service s3Service;
    private final CompanyService companyService;
    private final ServiceCategoryService categoryService;

    @Override
    public CreateProvidedServiceResponse create(CreateProvidedServiceRequest request) {

        
        companyService.get(request.getCompanyId()).orElseThrow(CompanyNotFoundException::new);
        categoryService.get(request.getCategoryId()).orElseThrow(ServiceCategoryNotFoundException::new);

        var providedServiceModel = providedserviceMapper.toModel(request);
        var providedservice = providedserviceService.create(providedServiceModel);

        return providedserviceMapper.toCreateResponse(providedservice);
    }

    @Override
    public UpdateProvidedServiceResponse update(Long id, UpdateProvidedServiceRequest request) {
        var providedServiceModel = providedserviceMapper.toModel(request);

        var existingProvidedService = providedserviceService.get(id);

        if (existingProvidedService.isEmpty()) {
            throw new ProvidedServiceNotFoundException("ProvidedService with id " + id + " does not exist");
        }

        providedServiceModel.setId(id);

        var providedservice = providedserviceService.create(providedServiceModel);

        return providedserviceMapper.toUpdateResponse(providedservice);
    }

    @Override
    public GetProvidedServiceResponse get(Long id) {
        var existingProvidedService = providedserviceService.get(id);

        if (existingProvidedService.isEmpty()) {
            throw new ProvidedServiceNotFoundException("ProvidedService with id " + id + " does not exist");
        }

        var providedservice = existingProvidedService.get();

        return providedserviceMapper.toGetResponse(providedservice);
    }

    @Override
    public Page<GetProvidedServiceResponse> getAll(int page, int size, SortProvidedServiceBy sortBy,
                                                   SortDirection sortDir, ProvidedServiceFilter filter) {
        Sort sort = sortDir.toString().equalsIgnoreCase("asc") ? Sort.by(sortBy.toString()).ascending() :
                Sort.by(sortBy.toString()).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<ProvidedService> result = providedserviceService.getAll(pageable, filter);

        List<GetProvidedServiceResponse> dtoList = result.stream()
                .map(providedserviceMapper::toGetResponse)
                .toList();

        return new PageImpl<>(dtoList, pageable, result.getTotalElements());
    }

    @Override
    public void delete(Long id) {
        var existingProvidedService = providedserviceService.get(id);

        if (existingProvidedService.isEmpty()) {
            throw new ProvidedServiceNotFoundException("ProvidedService with id " + id + " does not exist");
        }

        providedserviceService.delete(id);
    }

    @Override
    public void uploadCoverImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String url = s3Service.uploadFile(fileName, file, "provided-service/image/cover/");
        providedserviceService.updateCoverImageUrl(url, id);
    }
}
