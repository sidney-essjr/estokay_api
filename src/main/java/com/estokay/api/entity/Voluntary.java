package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @ToString
@DiscriminatorValue("Voluntary")
@AllArgsConstructor @NoArgsConstructor
public class Voluntary extends Person {

    @Column(name = "document", nullable = false)
    private String document;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    public enum Role {
        ROLE_ADMIN, ROLE_USER
    }
}
