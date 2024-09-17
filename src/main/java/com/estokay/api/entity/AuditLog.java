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

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;

    @Column(name = "old_value", nullable = false)
    private String oldValue;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "class_id", nullable = false)
    private Long classId;

    @Column(name = "record_id", nullable = false)
    private Long recordId;

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
