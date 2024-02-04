package com.sentryc.marketplaces.dto;

import com.sentryc.marketplaces.constants.PageInput;
import com.sentryc.marketplaces.constants.SellerFilter;
import com.sentryc.marketplaces.constants.SellerSortBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestSellerDataPost {
    private SellerFilter sellerFilter;
    private PageInput pageInput;
    private SellerSortBy sellerSortBy;
}
