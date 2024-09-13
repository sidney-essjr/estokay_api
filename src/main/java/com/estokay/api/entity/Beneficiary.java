package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Table(name = "Beneficiary")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "document", nullable = false, unique = true)
    private String document;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "donations_received")
    private int donationsReceived;

    @ManyToOne
    @JoinColumn(name = "audit_id", nullable = false)
    private AuditLog audit;
}
