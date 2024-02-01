package com.sentryc.marketplaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerPagebleResponse {
    private String sellerName;
    private String externalId;
    private String marketPlaceId;
    public List<ProducerSellerState> producerSellerStates;
}
