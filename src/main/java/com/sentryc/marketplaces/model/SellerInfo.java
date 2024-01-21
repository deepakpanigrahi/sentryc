package com.sentryc.marketplaces.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "seller_infos",
        uniqueConstraints = @UniqueConstraint(columnNames = {"marketplace_id", "external_id"}))
@NoArgsConstructor
@Data
public class SellerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(nullable = false, length = 2048)
    private String name;

    @Column(length = 2048)
    private String url;

    private String country;

    @Column(name = "external_id")
    private String externalId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marketplace_id", referencedColumnName = "id")
    private MarketPlace marketPlace;

    public SellerInfo(String name, String url, String country, String externalId, MarketPlace marketPlace) {
        this.name = name;
        this.url = url;
        this.country = country;
        this.externalId = externalId;
        this.marketPlace = marketPlace;
    }
}
