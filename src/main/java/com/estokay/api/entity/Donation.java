package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Table(name = "Donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "item_type_id")
    private ItemType itemType;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "size", nullable = false)
    private Size size;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure", nullable = false)
    private Measure measure;

    @Column(name = "validate")
    private LocalDate validate;

    @ManyToOne
    @JoinColumn(name = "audit_id")
    private AuditLog audit;

    public enum Size {
        SIZE_SMALL, SIZE_MEDIUM, SIZE_LARGE
    }

    public enum Measure {
        MEASURE_KG, MEASURE_L, MEASURE_UN, MEASURE_CM
    }
}
