package com.sentryc.marketplaces.controller;

import com.sentryc.marketplaces.dto.RequestSellerDataPost;
import com.sentryc.marketplaces.dto.SellerPagebleResponse;
import com.sentryc.marketplaces.service.MarketPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/marketplace/sellers")
public class SellerController {

    private final MarketPlaceService service;

    @PostMapping
    public ResponseEntity<List<SellerPagebleResponse>> getMarketPlaceData(@RequestBody RequestSellerDataPost sellerDataPost) {
        return ResponseEntity.ok(service.getSellerData(sellerDataPost));
    }
}
