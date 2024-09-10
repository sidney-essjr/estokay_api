package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Volunteers")
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

    @ManyToOne
    @JoinColumn(name = "audit_id")
    private AuditLog audit;

    public enum Role {
        ROLE_ADMIN, ROLE_USER
    }
}
