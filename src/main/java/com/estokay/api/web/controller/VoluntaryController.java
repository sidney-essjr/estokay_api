package com.estokay.api.web.controller;

import com.estokay.api.entity.Voluntary;
import com.estokay.api.service.VoluntaryService;
import com.estokay.api.web.dto.VoluntaryCreateDto;
import com.estokay.api.web.dto.VoluntaryResponseDto;
import com.estokay.api.web.dto.mapper.VoluntaryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/volunteers")
public class VoluntaryController {

    private final VoluntaryService voluntaryService;

    @PostMapping
    public ResponseEntity<VoluntaryResponseDto> create(@Valid @RequestBody VoluntaryCreateDto dto) {
        Voluntary voluntary = voluntaryService.save(VoluntaryMapper.toVoluntary(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(VoluntaryMapper.toDto(voluntary));
    }

}
