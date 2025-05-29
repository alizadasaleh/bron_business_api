package az.bron.business.common.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.search.mapper.pojo.bridge.builtin.annotation.GeoPointBinding;
import org.hibernate.search.mapper.pojo.bridge.builtin.annotation.Latitude;
import org.hibernate.search.mapper.pojo.bridge.builtin.annotation.Longitude;

@Data
@Embeddable
@GeoPointBinding(fieldName = "location")
public class Location {
    @Longitude
    private Double longitude;

    @Latitude
    private Double latitude;

}
