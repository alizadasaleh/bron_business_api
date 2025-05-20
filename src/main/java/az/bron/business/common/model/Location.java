package az.bron.business.common.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Location {
    private Double longitude;
    private Double latitude;

}
