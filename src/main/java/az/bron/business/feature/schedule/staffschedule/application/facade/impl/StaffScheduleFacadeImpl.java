package az.bron.business.feature.schedule.staffschedule.application.facade.impl;

import az.bron.business.feature.schedule.staffschedule.application.facade.StaffScheduleFacade;
import az.bron.business.feature.schedule.staffschedule.application.mapper.StaffScheduleMapper;
import az.bron.business.feature.schedule.staffschedule.application.model.request.CreateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.request.UpdateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.response.CreateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.GetStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.UpdateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.domain.model.StaffSchedule;
import az.bron.business.feature.schedule.staffschedule.domain.service.StaffScheduleService;
import az.bron.business.feature.staff.application.exception.StaffNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class StaffScheduleFacadeImpl implements StaffScheduleFacade {
    private final StaffScheduleService staffscheduleService;
    private final StaffScheduleMapper staffscheduleMapper;
    private final StaffScheduleService staffScheduleService;

    @Override
    public CreateStaffScheduleResponse create(CreateStaffScheduleRequest request) {
        staffScheduleService.get(request.getStaffId()).orElseThrow(StaffNotFoundException::new);
        StaffSchedule staffScheduleModel = staffscheduleMapper.toModel(request);
        StaffSchedule staffschedule = staffscheduleService.create(staffScheduleModel);

        return staffscheduleMapper.toCreateResponse(staffschedule);
    }

    @Override
    public UpdateStaffScheduleResponse update(Long id, UpdateStaffScheduleRequest request) {
        staffScheduleService.get(id).orElseThrow(StaffNotFoundException::new);  // replace with proper error

        StaffSchedule staffScheduleModel = staffscheduleMapper.toModel(request);


        staffScheduleModel.setId(id);

        StaffSchedule staffschedule = staffscheduleService.create(staffScheduleModel);

        return staffscheduleMapper.toUpdateResponse(staffschedule);
    }

    @Override
    public GetStaffScheduleResponse get(Long id) {
        Optional<StaffSchedule> existingStaffSchedule = staffscheduleService.get(id);

        if (existingStaffSchedule.isEmpty()) {
            throw new StaffNotFoundException(
                    "StaffSchedule with id " + id + " does not exist");  // replace with proper error
        }

        StaffSchedule staffschedule = existingStaffSchedule.get();

        return staffscheduleMapper.toGetResponse(staffschedule);
    }

    @Override
    public List<GetStaffScheduleResponse> getAll() {
        List<StaffSchedule> result = staffscheduleService.getAll();

        return result.stream()
                .map(staffscheduleMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        staffScheduleService.get(id).orElseThrow(StaffNotFoundException::new); // replace with proper error
        Optional<StaffSchedule> existingStaffSchedule = staffscheduleService.get(id);

        if (existingStaffSchedule.isEmpty()) {
            throw new InternalError("StaffSchedule with id " + id + " does not exist");
        }

        staffscheduleService.delete(id);
    }
}
