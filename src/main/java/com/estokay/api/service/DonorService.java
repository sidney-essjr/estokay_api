package com.estokay.api.service;

import com.estokay.api.entity.Donor;
import com.estokay.api.exception.EmailUniqueViolationException;
import com.estokay.api.repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DonorService {

    private final DonorRepository donorRepository;

    @Transactional
    public Donor save(Donor donor) {
        try {
            return donorRepository.save(donor);
        } catch (org.springframework.dao.DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException(String.format("The donor's email '%s' is already in use", donor.getEmail()));
        }
    }

}
