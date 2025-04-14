package az.bron.business.feature.staff.application.facade;

import az.bron.business.feature.staff.application.model.request.CreateStaffRequest;
import az.bron.business.feature.staff.application.model.request.UpdateStaffRequest;
import az.bron.business.feature.staff.application.model.response.CreateStaffResponse;
import az.bron.business.feature.staff.application.model.response.GetStaffResponse;
import az.bron.business.feature.staff.application.model.response.UpdateStaffResponse;
import az.bron.business.feature.staff.presentation.controller.StaffFilter;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface StaffFacade {
    CreateStaffResponse create(CreateStaffRequest request);

    UpdateStaffResponse update(Long id, UpdateStaffRequest request);

    GetStaffResponse get(Long id);

    List<GetStaffResponse> getAll(StaffFilter filter);

    void delete(Long id);

    void uploadProfileImage(Long id, MultipartFile file) throws IOException;
}
