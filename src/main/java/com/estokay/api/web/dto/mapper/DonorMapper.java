package com.estokay.api.web.dto.mapper;

import com.estokay.api.entity.Donor;
import com.estokay.api.web.dto.DonorCreateDto;
import com.estokay.api.web.dto.DonorResponseDto;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class DonorMapper {

    public static Donor toDonor(DonorCreateDto dto) {
        return new ModelMapper().map(dto, Donor.class);
    }

    public static DonorResponseDto toDto(Donor donor) {
        return new ModelMapper().map(donor, DonorResponseDto.class);
    }

    public static List<DonorResponseDto> toListDto(List<Donor> donors) {
        return donors.stream().map(DonorMapper::toDto).collect(Collectors.toList());
    }

}
