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

    @NotBlank
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 10)
    private String phone;

    @NotBlank
    @Email(regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String email;

    private String code;

    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private int donationsMade;

    @NotBlank
    private boolean isActive;

}
