package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Table(name = "Distribution")
public class Distribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "beneficiary_id", nullable = false)
    private Beneficiary beneficiary;

    @OneToMany
    @JoinColumn(name = "distribution_id", nullable = false)
    @ToString.Exclude
    private List<Donation> donations;

    @Column(name = "distribution_date", nullable = false)
    private LocalDateTime distributionDate;

}
