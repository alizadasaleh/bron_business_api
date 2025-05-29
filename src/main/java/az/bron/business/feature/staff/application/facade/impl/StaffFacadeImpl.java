package az.bron.business.feature.staff.application.facade.impl;

import az.bron.business.config.S3Service;
import az.bron.business.feature.staff.application.exception.StaffNotFoundException;
import az.bron.business.feature.staff.application.facade.StaffFacade;
import az.bron.business.feature.staff.application.mapper.StaffMapper;
import az.bron.business.feature.staff.application.model.request.CreateStaffRequest;
import az.bron.business.feature.staff.application.model.request.UpdateStaffRequest;
import az.bron.business.feature.staff.application.model.response.CreateStaffResponse;
import az.bron.business.feature.staff.application.model.response.GetStaffResponse;
import az.bron.business.feature.staff.application.model.response.UpdateStaffResponse;
import az.bron.business.feature.staff.domain.service.StaffService;
import az.bron.business.feature.staff.presentation.controller.StaffFilter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Log4j2
@Service
public class StaffFacadeImpl implements StaffFacade {
    private final StaffService staffService;
    private final StaffMapper staffMapper;
    private final S3Service s3Service;

    public StaffFacadeImpl(StaffService staffService, StaffMapper staffMapper, S3Service s3Service) {
        this.staffService = staffService;
        this.staffMapper = staffMapper;
        this.s3Service = s3Service;
    }

    @Override
    public CreateStaffResponse create(CreateStaffRequest request) {
        var staffModel = staffMapper.toModel(request);
        var staff = staffService.create(staffModel);

        return staffMapper.toCreateResponse(staff);
    }

    @Override
    public UpdateStaffResponse update(Long id, UpdateStaffRequest request) {
        var staffModel = staffMapper.toModel(request);

        var existingStaff = staffService.get(id);

        if (existingStaff.isEmpty()) {
            throw new StaffNotFoundException("Staff with id " + id + " does not exist");
        }

        staffModel.setId(id);

        var staff = staffService.create(staffModel);

        return staffMapper.toUpdateResponse(staff);
    }

    @Override
    public GetStaffResponse get(Long id) {
        var existingStaff = staffService.get(id);

        if (existingStaff.isEmpty()) {
            throw new StaffNotFoundException("Staff with id " + id + " does not exist");
        }

        var staff = existingStaff.get();

        return staffMapper.toGetResponse(staff);
    }

    @Override
    public List<GetStaffResponse> getAll(StaffFilter filter) {
        var result = staffService.getAll(filter);

        return result.stream()
                .map(staffMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingStaff = staffService.get(id);

        if (existingStaff.isEmpty()) {
            throw new StaffNotFoundException("Staff with id " + id + " does not exist");
        }

        staffService.delete(id);
    }

    @Override
    public void uploadProfileImage(Long id, MultipartFile file) throws IOException {
        String fileName = String.valueOf(UUID.randomUUID());
        String url = s3Service.uploadFile(fileName, file, "staff/image/profile/");
        staffService.updateProfileImageUrl(url, id);
    }
}
