package com.estokay.api.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonorResponseDto {

    private long id;

    private String name;

    private String phone;

    private String email;

    private String code;

    private String address;

    private String city;

    private String state;

    private int donationsMade;

    private boolean isActive;

}
