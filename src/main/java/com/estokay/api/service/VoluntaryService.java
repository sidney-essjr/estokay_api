package com.estokay.api.service;

import com.estokay.api.entity.AuditLog;
import com.estokay.api.entity.Voluntary;
import com.estokay.api.exception.EmailUniqueViolationException;
import com.estokay.api.exception.EntityNotFoundException;
import com.estokay.api.repository.VoluntaryRepository;
import com.estokay.api.web.dto.VoluntaryCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoluntaryService {

    private final VoluntaryRepository voluntaryRepository;

    @Transactional
    public Voluntary save(Voluntary voluntary) {
        try {
        return voluntaryRepository.save(voluntary);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException(String.format(
                    "The volunteer's email '%s' is already in use", voluntary.getEmail()));
        }
    }

    @Transactional(readOnly = true)
    public Voluntary findById(long id) {
        return voluntaryRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("The id entity %d was not found", id))
        );
    }

    @Transactional(readOnly = true)
    public List<Voluntary> findAll() {
        return voluntaryRepository.findAll();
    }

    @Transactional
    public void update(long id, VoluntaryCreateDto dto) {
        Voluntary voluntary = findById(id);
        BeanUtils.copyProperties(dto, voluntary, getNullPropertyNames(dto));
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
