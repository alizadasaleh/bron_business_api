package az.bron.business.feature.appointment.application.model.response;

import lombok.Data;

@Data
public class GetAppointmentResponse {
    private Long id;
    private Long companyId;
    private String companyName;
    private String companyAddressName;
    private String serviceName;
    private Double price;
}