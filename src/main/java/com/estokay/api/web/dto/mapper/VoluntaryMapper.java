package com.estokay.api.web.dto.mapper;


import com.estokay.api.entity.Voluntary;
import com.estokay.api.web.dto.VoluntaryCreateDto;
import com.estokay.api.web.dto.VoluntaryResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class VoluntaryMapper {

    public static Voluntary toVoluntary(VoluntaryCreateDto dto) {
        return new ModelMapper().map(dto, Voluntary.class);
    }

    public static VoluntaryResponseDto toDto(Voluntary voluntary) {
        String role = voluntary.getRole().name().substring("ROLE_".length());

        PropertyMap<Voluntary, VoluntaryResponseDto> props = new PropertyMap<Voluntary, VoluntaryResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);

        return mapper.map(voluntary, VoluntaryResponseDto.class);
    }

    public static List<VoluntaryResponseDto> toListDto(List<Voluntary> volunteers) {
        return volunteers.stream().map(VoluntaryMapper::toDto).collect(Collectors.toList());
    }
}
