package com.sentryc.marketplaces.dto;

import com.sentryc.marketplaces.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProducerSellerState implements Serializable {
    private String producerId;
    private String producerName;
    private State state;
    private String sellerId;
}
