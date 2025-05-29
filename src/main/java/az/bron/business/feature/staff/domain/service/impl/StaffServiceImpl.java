package az.bron.business.feature.staff.domain.service.impl;

import az.bron.business.feature.staff.domain.model.Staff;
import az.bron.business.feature.staff.domain.repository.StaffRepository;
import az.bron.business.feature.staff.domain.service.StaffService;
import az.bron.business.feature.staff.infrastruture.persistence.StaffRepositoryMybatis;
import az.bron.business.feature.staff.presentation.controller.StaffFilter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final StaffRepositoryMybatis staffRepositoryMybatis;

    @Override
    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Optional<Staff> get(Long id) {
        return staffRepository.findById(id);
    }

    @Override
    public List<Staff> getAll(StaffFilter filter) {
        return staffRepositoryMybatis.selectList(
                new QueryWrapper<Staff>()
                        .lambda()
                        .eq(filter.getCompanyId() != null, Staff::getCompanyId, filter.getCompanyId())
        );
    }

//    @Override
//    public List<Staff> getAllByCompanyId(Long companyId) {
//        return staffRepository.findAllByCompanyId(companyId);
//    }

    @Override
    public void delete(Long id) {
        staffRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateProfileImageUrl(String fileName, Long id) {
        staffRepository.insertProfileImageUrl(fileName, id);
    }
}
