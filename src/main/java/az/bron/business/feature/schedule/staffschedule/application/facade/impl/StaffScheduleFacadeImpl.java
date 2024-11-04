package az.bron.business.feature.schedule.staffschedule.application.facade.impl;

import az.bron.business.feature.schedule.staffschedule.application.facade.StaffScheduleFacade;
import az.bron.business.feature.schedule.staffschedule.application.mapper.StaffScheduleMapper;
import az.bron.business.feature.schedule.staffschedule.application.model.request.CreateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.request.UpdateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.response.CreateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.GetStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.UpdateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.domain.service.StaffScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class StaffScheduleFacadeImpl implements StaffScheduleFacade {
    private final StaffScheduleService staffscheduleService;
    private final StaffScheduleMapper staffscheduleMapper;

    @Override
    public CreateStaffScheduleResponse create(CreateStaffScheduleRequest request) {
        var staffscheduleModel = staffscheduleMapper.toModel(request);
        var staffschedule = staffscheduleService.create(staffscheduleModel);

        return staffscheduleMapper.toCreateResponse(staffschedule);
    }

    @Override
    public UpdateStaffScheduleResponse update(Long id, UpdateStaffScheduleRequest request) {
        var staffscheduleModel = staffscheduleMapper.toModel(request);

        var existingStaffSchedule = staffscheduleService.get(id);

        if (existingStaffSchedule.isEmpty()) {
            throw new InternalError("StaffSchedule with id " + id + " does not exist");
        }

       staffscheduleModel.setId(id);

        var staffschedule = staffscheduleService.create(staffscheduleModel);

        return staffscheduleMapper.toUpdateResponse(staffschedule);
    }

    @Override
    public GetStaffScheduleResponse get(Long id) {
        var existingStaffSchedule = staffscheduleService.get(id);

        if (existingStaffSchedule.isEmpty()) {
            throw new InternalError("StaffSchedule with id " + id + " does not exist");
        }

        var staffschedule = existingStaffSchedule.get();

        return staffscheduleMapper.toGetResponse(staffschedule);
    }

    @Override
    public List<GetStaffScheduleResponse> getAll() {
        var result = staffscheduleService.getAll();

        return result.stream()
                .map(staffscheduleMapper::toGetResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        var existingStaffSchedule = staffscheduleService.get(id);

        if (existingStaffSchedule.isEmpty()) {
            throw new InternalError("StaffSchedule with id " + id + " does not exist");
        }

       staffscheduleService.delete(id);
    }
}
