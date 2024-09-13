package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "audit_logs")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class AuditLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "Operation", nullable = false, length = 20)
    private Operation operationType = Operation.INSERT;

    @Column(name = "created_in", nullable = false)
    private LocalDateTime createdIn;

    @ManyToOne
    @JoinColumn(name = "id_created", nullable = false)
    private Voluntary createdBy;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;

    @ManyToOne
    @JoinColumn(name = "id_changed", nullable = false)
    private Voluntary changedBy;

    @Column(name = "old_value")
    private String oldValue;

    public enum Operation {
        INSERT, UPDATE, DELETE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditLog auditLog = (AuditLog) o;
        return id == auditLog.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
