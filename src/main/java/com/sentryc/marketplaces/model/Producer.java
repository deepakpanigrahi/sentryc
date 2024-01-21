package com.sentryc.marketplaces.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "producers")
@NoArgsConstructor
@Data
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", nullable = false, updatable = false)
    private UUID id;

    private String name;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    public Producer(String name, Timestamp createdAt) {
        this.name = name;
        this.createdAt = createdAt;
    }
}
