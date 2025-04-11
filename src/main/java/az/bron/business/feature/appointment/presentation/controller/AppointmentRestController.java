package az.bron.business.feature.appointment.presentation.controller;

import az.bron.business.feature.appointment.application.facade.AppointmentFacade;
import az.bron.business.feature.appointment.application.model.request.CreateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.request.UpdateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.response.CreateAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.GetAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.UpdateAppointmentResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/appointments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "bearerAuth")
public class AppointmentRestController {
    private final AppointmentFacade appointmentFacade;

    @GetMapping
    public ResponseEntity<List<GetAppointmentResponse>> getAppointment() {
        List<GetAppointmentResponse> response = appointmentFacade.getAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAppointmentResponse> get(@PathVariable("id") Long id) {
        GetAppointmentResponse response = appointmentFacade.get(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateAppointmentResponse> create(@RequestBody CreateAppointmentRequest request) {
        CreateAppointmentResponse response = appointmentFacade.create(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateAppointmentResponse> update(@PathVariable("id") Long id,
                                                            @RequestBody UpdateAppointmentRequest request) {
        UpdateAppointmentResponse response = appointmentFacade.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        appointmentFacade.delete(id);
    }
}
