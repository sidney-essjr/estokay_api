package com.estokay.api.service;

import com.estokay.api.entity.AuditLog;
import com.estokay.api.entity.Voluntary;
import com.estokay.api.exception.EmailUniqueViolationException;
import com.estokay.api.exception.EntityNotFoundException;
import com.estokay.api.repository.VoluntaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VoluntaryService {

    private final VoluntaryRepository voluntaryRepository;

    @Transactional
    public Voluntary save(Voluntary voluntary) {
        try {
            AuditLog audit = new AuditLog();
            audit.setId(1);
            voluntary.setAudit(audit);
        return voluntaryRepository.save(voluntary);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException(String.format(
                    "The volunteer's email '%s' is already in use", voluntary.getEmail()));
        }
    }

    @Transactional(readOnly = true)
    public Voluntary findById(long id) {
        return voluntaryRepository.findById(id).get();
    }
}
