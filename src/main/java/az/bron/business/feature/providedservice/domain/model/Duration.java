package az.bron.business.feature.providedservice.domain.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;

@Data
@Embeddable
public class Duration implements Serializable {
    private Integer hours;
    private Integer minutes;
}
