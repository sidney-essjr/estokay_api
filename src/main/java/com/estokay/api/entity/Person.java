package com.estokay.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "People")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "code", nullable = true, length = 20)
    private String code;

    @Column(name = "address", nullable = false, length = 255)
    private String address;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name = "state", nullable = false, length = 255)
    private String state;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "record_id")
    private long recordId;

    @Enumerated(EnumType.STRING)
    @Column(name = "Operation", nullable = false, length = 20)
    private Operation operationType = Operation.UNCHANGED;

    @Column(name = "created_in", nullable = false)
    private LocalDateTime createdIn;

    @Column(name = "changed_at", nullable = false)
    private LocalDateTime changedAt;

    @Column(name = "changed_by", nullable = false)
    private String changedBy;

    @Column(name = "old_value")
    private String oldValue;

    public enum Operation {
        INSERT, UPDATE, DELETE, UNCHANGED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
