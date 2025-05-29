package az.bron.business.feature.company.domain.model.address;

import az.bron.business.common.model.Location;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;


@Data
@Embeddable
public class Address {
    @IndexedEmbedded
    private Location location;
    private String postalCode;
    private String city;
    private String state;
    private String street;
}
