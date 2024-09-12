package com.estokay.api.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoluntaryCreateDto {

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
    private String document;

    @NotBlank
    @Size(min = 6, max = 20)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[\\W_])(?=.{6,20}$).*", message = "Requirements: " +
            "1-At least one capital letter " +
            "2-At least one symbol (special character) " +
            "3-At least 6 characters and a maximum of 20 characters")
    private String password;
}
