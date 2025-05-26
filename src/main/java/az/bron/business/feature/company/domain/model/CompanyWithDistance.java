package az.bron.business.feature.company.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.geo.Distance;

public class CompanyWithDistance {
    private Company company;
    private Double distanceKm;

    public CompanyWithDistance(Company company, Double distanceKm) {
        this.company = company;
        this.distanceKm = distanceKm;
    }

    // Getters and setters
    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
    public Double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(Double distanceKm) { this.distanceKm = distanceKm; }
}