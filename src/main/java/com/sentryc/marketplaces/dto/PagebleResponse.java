package com.sentryc.marketplaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagebleResponse {
    private String sellerName;
    private String externalId;
    private String marketPlaceId;
    private List<ProducerSellerInfo> producerSellerInfos;
}
