package az.bron.business.feature.schedule.staffschedule.presentation.controller;

import az.bron.business.feature.schedule.staffschedule.application.facade.StaffScheduleFacade;
import az.bron.business.feature.schedule.staffschedule.application.model.request.CreateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.request.UpdateStaffScheduleRequest;
import az.bron.business.feature.schedule.staffschedule.application.model.response.CreateStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.GetStaffScheduleResponse;
import az.bron.business.feature.schedule.staffschedule.application.model.response.UpdateStaffScheduleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/StaffSchedules")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class StaffScheduleRestController {
    private final StaffScheduleFacade staffscheduleFacade;

    @GetMapping
    public ResponseEntity<List<GetStaffScheduleResponse>> getStaffSchedule() {
        var response = staffscheduleFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetStaffScheduleResponse> get(@PathVariable("id") Long id) {
        var response = staffscheduleFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateStaffScheduleResponse> create(@RequestBody CreateStaffScheduleRequest request) {
        var response = staffscheduleFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStaffScheduleResponse> update(@PathVariable("id") Long id, @RequestBody UpdateStaffScheduleRequest request) {
        var response = staffscheduleFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       staffscheduleFacade.delete(id);
    }
}
