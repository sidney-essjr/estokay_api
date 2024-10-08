package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "Volunteers")
@Getter @Setter @ToString
@DiscriminatorValue("Voluntary")
@AllArgsConstructor @NoArgsConstructor
public class Voluntary extends Person implements Serializable {

    @Column(name = "document", nullable = false, unique = true)
    private String document;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role = Role.ROLE_USER;

    public enum Role {
        ROLE_ADMIN, ROLE_USER
    }
}
