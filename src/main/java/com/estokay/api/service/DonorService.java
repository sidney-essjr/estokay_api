package com.estokay.api.service;

import com.estokay.api.entity.AuditLog;
import com.estokay.api.entity.Donor;
import com.estokay.api.entity.Voluntary;
import com.estokay.api.exception.EmailUniqueViolationException;
import com.estokay.api.exception.EntityNotFoundException;
import com.estokay.api.repository.DonorRepository;
import com.estokay.api.web.dto.DonorCreateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DonorService {

    private final DonorRepository donorRepository;
    private final AuditLogService<Donor> auditLogService;

    @Transactional
    public Donor save(Donor donor) {
        try {
            // substituir pelo usuário no contexto do spring security
            Voluntary voluntary = new Voluntary();
            voluntary.setId(1L);

            Donor createdDonor = donorRepository.save(donor);

            AuditLog auditLog = auditLogService.save(voluntary, createdDonor, AuditLog.Operation.INSERT);

            log.info(auditLog.toString());

            return createdDonor;
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException(String.format("The donor's email '%s' is already in use", donor.getEmail()));
        }
    }

    @Transactional(readOnly = true)
    public Donor findById(long id) {
        return donorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("The id entity %d was not found", id))
        );
    }

    @Transactional(readOnly = true)
    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    @Transactional
    public void update(long id, DonorCreateDto dto) {
        Donor donor = findById(id);
        BeanUtils.copyProperties(dto, donor, getNullPropertyNames(dto));
    }

    @Transactional
    public void addDonationsMade(long id) {
        Donor donor = findById(id);
        donor.setDonationsMade(donor.getDonationsMade() + 1);
    }

    @Transactional
    public void swapIsActive(long id) {
        Donor donor = findById(id);
        donor.setActive(!donor.isActive());
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        java.util.List<String> nullPropertyNames = new java.util.ArrayList<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                nullPropertyNames.add(pd.getName());
            }
        }
        return nullPropertyNames.toArray(new String[0]);
    }

}
