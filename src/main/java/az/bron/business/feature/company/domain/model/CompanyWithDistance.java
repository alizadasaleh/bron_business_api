package az.bron.business.feature.company.domain.model;

public class CompanyWithDistance {
    private Company company;
    private Double distance;

    public CompanyWithDistance(Company company, Double distance) {
        this.company = company;
        this.distance = distance;
    }

    // Getters and setters
    public Company getCompany() { return company; }
    public void setCompany(Company company) { this.company = company; }
    public Double getDistance() { return distance; }
    public void setDistance(Double distance) { this.distance = distance; }
}