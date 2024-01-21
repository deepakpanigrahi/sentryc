package com.sentryc.marketplaces.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "sellers")
@NoArgsConstructor
@Data
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "producer_id", referencedColumnName = "id", nullable = false)
    private Producer producer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_info_id", referencedColumnName = "id")
    private SellerInfo sellerInfo;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    public Seller(Producer producer, SellerInfo sellerInfo, State state) {
        this.producer = producer;
        this.sellerInfo = sellerInfo;
        this.state = state;
    }
}
