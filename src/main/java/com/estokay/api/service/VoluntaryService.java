package com.estokay.api.service;

import com.estokay.api.entity.Voluntary;
import com.estokay.api.exception.EmailUniqueViolationException;
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
        return voluntaryRepository.save(voluntary);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException(String.format("The volunteer's email '%s' is already in use", voluntary.getEmail()));
        }
    }
}
