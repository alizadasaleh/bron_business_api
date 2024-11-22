package az.bron.business.feature.company.application.mapper;

import az.bron.business.feature.company.application.model.request.CreateCompanyRequest;
import az.bron.business.feature.company.application.model.request.UpdateCompanyRequest;
import az.bron.business.feature.company.application.model.response.CompanySearchResponse;
import az.bron.business.feature.company.application.model.response.CreateCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyResponse;
import az.bron.business.feature.company.application.model.response.GetCompanyWithDetailsResponse;
import az.bron.business.feature.company.application.model.response.UpdateCompanyResponse;
import az.bron.business.feature.company.domain.model.Company;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toModel(CreateCompanyRequest request);

    Company toModel(UpdateCompanyRequest request);

    CreateCompanyResponse toCreateResponse(Company company);

    UpdateCompanyResponse toUpdateResponse(Company company);

    GetCompanyResponse toGetResponse(Company company);

    GetCompanyWithDetailsResponse toGetWithDetailsResponse(Company company);

    List<GetCompanyWithDetailsResponse> toGetWithDetailsResponse(List<Company> company);

    List<CompanySearchResponse> toCompanySearchResponse(List<Company> search);
}
