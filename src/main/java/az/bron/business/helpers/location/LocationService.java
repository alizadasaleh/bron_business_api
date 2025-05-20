package az.bron.business.helpers.location;

import az.bron.business.common.model.Location;

public interface LocationService {
    Double calculateDistance(Location location1, Location location2);
}
