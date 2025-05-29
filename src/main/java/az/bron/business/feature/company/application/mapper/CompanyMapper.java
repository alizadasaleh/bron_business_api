package az.bron.business.feature.company.application.mapper;

import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CompanySearchResponse;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyWithDetailsResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.model.Company;
import az.bron.business.feature.company.domain.model.CompanyWithDistance;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toModel(CreateCompanyRequest request);

    Company toModel(UpdateCompanyRequest request);

    CreateCompanyResponse toCreateResponse(Company company);

    UpdateCompanyResponse toUpdateResponse(Company company);

    GetCompanyResponse toGetResponse(Company company);

    GetCompanyWithDetailsResponse toGetWithDetailsResponse(Company company);

    List<GetCompanyWithDetailsResponse> toGetWithDetailsResponse(List<Company> company);

    @Mapping(source = "company.id", target = "id")
    @Mapping(source = "company.name", target = "name")
    @Mapping(source = "distance", target = "distance")
    @Mapping(source = "company.address.location", target = "location")
    CompanySearchResponse toSearchResponse(CompanyWithDistance companyWithDistance);

    List<CompanySearchResponse> toCompanySearchResponse(List<CompanyWithDistance> search);
}
