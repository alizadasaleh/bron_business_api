package az.bron.business.feature.providedservice.application.model.request;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Duration implements Serializable {
    private Integer hours;
    private Integer minutes;
}
