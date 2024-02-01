package com.sentryc.marketplaces.service;

import com.sentryc.marketplaces.constants.SellerFilter;
import com.sentryc.marketplaces.constants.SellerSortBy;
import com.sentryc.marketplaces.dto.ProducerSellerState;
import com.sentryc.marketplaces.dto.RequestSellerDataPost;
import com.sentryc.marketplaces.dto.SellerPagebleResponse;
import com.sentryc.marketplaces.model.Seller;
import com.sentryc.marketplaces.model.SellerInfo;
import com.sentryc.marketplaces.repos.SellerInfoRepo;
import com.sentryc.marketplaces.repos.SellerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log
public class MarketPlaceService {

    private final SellerRepo sellerRepo;
    private final SellerInfoRepo sellerInfoRepo;

    public List<SellerPagebleResponse> getSellerData(RequestSellerDataPost sellerDataPost) {
        int pageNumber = sellerDataPost.getPageInput().getPageNumber();
        int pageSize = sellerDataPost.getPageInput().getPageSize();
        Sort.Direction direction = sellerDataPost.getSellerSortBy() ==
                SellerSortBy.ASC ? Sort.Direction.ASC : Sort.Direction.DESC;

        PageRequest request = PageRequest.of(pageNumber, pageSize).withSort(direction,"state");
        return sellerRepo.findAll(request).stream().map(this::convertToDto).toList();
    }

    public SellerPagebleResponse convertToDto(Seller seller) {
        List<ProducerSellerState> states = new ArrayList<>(
                sellerRepo.findAll().stream().map(t -> new ProducerSellerState(
                t.getProducer().getId().toString(), t.getProducer().getName(),
                t.getState(), t.getSellerInfo().getId().toString())).toList());
        return SellerPagebleResponse.builder()
                .sellerName(seller.getSellerInfo().getName())
                .externalId(seller.getSellerInfo().getExternalId())
                .marketPlaceId(seller.getSellerInfo().getMarketPlace().getId())
                .producerSellerStates(states)
                .build();
    }
}
