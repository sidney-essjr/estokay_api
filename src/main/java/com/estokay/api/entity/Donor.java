package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "Donors")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Donor extends Person implements Serializable {

    @Column(name = "donations_made")
    private int donationsMade;

    @ManyToOne
    @JoinColumn(name = "audit_id")
    private AuditLog audit;

}
