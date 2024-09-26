package az.bron.business.feature.schedule.companyschedule.presentation.controller;

import az.bron.business.feature.schedule.companyschedule.application.facade.CompanyScheduleFacade;
import az.bron.business.feature.schedule.companyschedule.application.model.request.CreateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.request.UpdateCompanyScheduleRequest;
import az.bron.business.feature.schedule.companyschedule.application.model.response.CreateCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.GetCompanyScheduleResponse;
import az.bron.business.feature.schedule.companyschedule.application.model.response.UpdateCompanyScheduleResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/companySchedules")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Schedules")
public class CompanyScheduleRestController {
    private final CompanyScheduleFacade companyscheduleFacade;

    @GetMapping
    public ResponseEntity<List<GetCompanyScheduleResponse>> getCompanySchedule() {
        var response = companyscheduleFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyScheduleResponse> get(@PathVariable("id") Long id) {
        var response = companyscheduleFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateCompanyScheduleResponse> create(@RequestBody CreateCompanyScheduleRequest request) {
        var response = companyscheduleFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCompanyScheduleResponse> update(@PathVariable("id") Long id, @RequestBody UpdateCompanyScheduleRequest request) {
        var response = companyscheduleFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
       companyscheduleFacade.delete(id);
    }
}
