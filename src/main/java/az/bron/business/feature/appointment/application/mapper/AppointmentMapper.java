package az.bron.business.feature.appointment.application.mapper;

import az.bron.business.feature.appointment.application.model.request.CreateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.request.UpdateAppointmentRequest;
import az.bron.business.feature.appointment.application.model.response.CreateAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.GetAppointmentResponse;
import az.bron.business.feature.appointment.application.model.response.UpdateAppointmentResponse;
import az.bron.business.feature.appointment.domain.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(source = "providedServiceId", target = "providedService.id")
    @Mapping(source = "staffId", target = "staff.id")
    Appointment toModel(CreateAppointmentRequest request);

    Appointment toModel(UpdateAppointmentRequest request);

    CreateAppointmentResponse toCreateResponse(Appointment appointment);

    UpdateAppointmentResponse toUpdateResponse(Appointment appointment);

    @Mapping(target = "companyId",source = "providedService.company.id")
    @Mapping(target = "companyName", source = "providedService.company.name")
    @Mapping(target = "companyAddressName", source = "providedService.company.address.street")
    @Mapping(target = "serviceName", source = "providedService.name")
    GetAppointmentResponse toGetResponse(Appointment appointment);
}
