package com.sentryc.marketplaces.controller;

import com.sentryc.marketplaces.dto.PagebleResponse;
import com.sentryc.marketplaces.model.Seller;
import com.sentryc.marketplaces.model.SellerInfo;
import com.sentryc.marketplaces.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/marketplace/sellers")
public class SellerController {

    private final SellerService service;

    @GetMapping
    public ResponseEntity<Page<Seller>> findSellersByPageAndSize(@RequestParam(defaultValue = "1") int page,
                                                                 @RequestParam(defaultValue = "10") int size) {
        Page<Seller> sellerInfo = service.findByPageAndSize(page, size);
        return new ResponseEntity<>(sellerInfo, HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<SellerInfo> getSellerByName(@PathVariable String name) {
        SellerInfo sellerInfo = service.searchSellerByName(name);
        return new ResponseEntity<>(sellerInfo, HttpStatus.OK);
    }

    @GetMapping(value = "/fieldAndSorting")
    public ResponseEntity<Page<SellerInfo>> findSellersWithValueAndSorting(@RequestParam(defaultValue = "1") int page,
                                                                           @RequestParam(defaultValue = "10") int size,
                                                                           @RequestParam(defaultValue = "0") int direction,
                                                                           @RequestParam() String value) {
        SellerService.SortValues toSortWith = Arrays.stream(SellerService.SortValues.values())
                .filter(v -> v.getText().equals(value)).findFirst().get();
        Page<SellerInfo> sellerInfo = service.getSellerInfoWithSortDirection(
                page, size, toSortWith,
                direction == 0 ? Sort.Direction.ASC : Sort.Direction.DESC);
        return new ResponseEntity<>(sellerInfo, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PagebleResponse>> getAllSellerData() {
        return new ResponseEntity<>(service.getAllSellerData(), HttpStatus.OK);
    }
}
