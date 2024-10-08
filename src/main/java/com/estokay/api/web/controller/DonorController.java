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
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<DonorResponseDto> getById(@PathVariable long id) {
        Donor donor = donorService.findById(id);
        return ResponseEntity.ok(DonorMapper.toDto(donor));
    }

    @GetMapping
    public ResponseEntity<List<DonorResponseDto>> findAll() {
        List<Donor> donors = donorService.findAll();
        return ResponseEntity.ok(DonorMapper.toListDto(donors));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @Valid @RequestBody DonorCreateDto dto) {
        donorService.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/add-donations-made")
    public ResponseEntity<Void> addDonationsMade(@PathVariable long id) {
        donorService.addDonationsMade(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/swap-is-active")
    public ResponseEntity<Void> swapIsActive(@PathVariable long id) {
        donorService.swapIsActive(id);
        return ResponseEntity.noContent().build();
    }

}
