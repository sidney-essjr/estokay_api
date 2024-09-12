package com.estokay.api.web.dto;

import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoluntaryResponseDto {

    private long id;

    private String name;

    private String phone;

    private String email;

    private String code;

    private String address;

    private String city;

    private String state;

    private boolean isActive;

    private String document;

    private String role;

}
