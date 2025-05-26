package az.bron.business.common.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.search.mapper.pojo.bridge.builtin.annotation.GeoPointBinding;

@Data
@Embeddable
@GeoPointBinding
public class Location {
    private Double longitude;
    private Double latitude;

}
