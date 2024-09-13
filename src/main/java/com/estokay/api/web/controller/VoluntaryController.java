package com.estokay.api.web.controller;

import com.estokay.api.entity.Voluntary;
import com.estokay.api.service.VoluntaryService;
import com.estokay.api.web.dto.VoluntaryCreateDto;
import com.estokay.api.web.dto.VoluntaryResponseDto;
import com.estokay.api.web.dto.mapper.VoluntaryMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/volunteers")
public class VoluntaryController {

    private final VoluntaryService voluntaryService;

    @PostMapping
    public ResponseEntity<VoluntaryResponseDto> create(@Valid @RequestBody VoluntaryCreateDto dto) {
        Voluntary voluntary = voluntaryService.save(VoluntaryMapper.toVoluntary(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(VoluntaryMapper.toDto(voluntary));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoluntaryResponseDto> findById(@PathVariable long id) {
        Voluntary voluntary = voluntaryService.findById(id);
        return ResponseEntity.ok(VoluntaryMapper.toDto(voluntary));
    }

    @GetMapping
    public ResponseEntity<List<VoluntaryResponseDto>> findAll() {
        List<Voluntary> volunteers = voluntaryService.findAll();
        return ResponseEntity.ok(VoluntaryMapper.toListDto(volunteers));
    }

}
