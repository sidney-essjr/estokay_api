package com.estokay.api.web.controller;

import com.estokay.api.entity.Donor;
import com.estokay.api.service.DonorService;
import com.estokay.api.web.dto.DonorCreateDto;
import com.estokay.api.web.dto.DonorResponseDto;
import com.estokay.api.web.dto.mapper.DonorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/donors")
public class DonorController {

    private final DonorService donorService;

    @PostMapping
    public ResponseEntity<DonorResponseDto> create(@Valid @RequestBody DonorCreateDto donorDto) {
        Donor donor = donorService.save(DonorMapper.toDonor(donorDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(DonorMapper.toDto(donor));
    }
}
