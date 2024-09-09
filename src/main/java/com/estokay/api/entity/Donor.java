package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter @Setter @ToString
@DiscriminatorValue("Donor")
@AllArgsConstructor @NoArgsConstructor
public class Donor extends Person {

    @Column(name = "donations_made")
    private int donationsMade;

    @ManyToOne
    @JoinColumn(name = "audit_id")
    private AuditLog audit;

}
