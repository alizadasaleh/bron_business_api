package az.bron.business.helpers.location.impl;

import az.bron.business.common.model.Location;
import az.bron.business.helpers.location.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private static final double EARTH_RADIUS_KM = 6371.0;

    @Override
    public Double calculateDistance(Location location1, Location location2) {
        if (location1 == null || location2 == null
                || location1.getLatitude() == null || location1.getLongitude() == null
                || location2.getLatitude() == null || location2.getLongitude() == null) {
            return null;
        }

        double lat1 = Math.toRadians(location1.getLatitude());
        double lon1 = Math.toRadians(location1.getLongitude());
        double lat2 = Math.toRadians(location2.getLatitude());
        double lon2 = Math.toRadians(location2.getLongitude());

        double deltaLat = lat2 - lat1;
        double deltaLon = lon2 - lon1;

        double a = Math.pow(Math.sin(deltaLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(deltaLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }
}
