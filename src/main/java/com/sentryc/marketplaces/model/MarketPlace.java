package com.sentryc.marketplaces.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "marketplaces")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarketPlace {

    @Id
    @Column(nullable = false)
    private String id;
    private String description;
}
