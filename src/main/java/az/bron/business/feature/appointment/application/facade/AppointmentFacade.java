package az.bron.business.feature.appointment.application.facade;

import az.bron.business.feature.appointment.application.model.request.CreateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.request.UpdateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.response.CreateAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.GetAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.UpdateAppointmentResponse;
import java.util.List;

public interface AppointmentFacade {
    CreateAppointmentResponse create(CreateAppointmentRequest request);

    UpdateAppointmentResponse update(Long id, UpdateAppointmentRequest request);

    GetAppointmentResponse get(Long id);

    List<GetAppointmentResponse> getAll();

    void delete(Long id);
}
