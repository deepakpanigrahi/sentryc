package com.sentryc.marketplaces.service;

import com.sentryc.marketplaces.dto.PagebleResponse;
import com.sentryc.marketplaces.dto.ProducerSellerInfo;
import com.sentryc.marketplaces.model.Seller;
import com.sentryc.marketplaces.model.SellerInfo;
import com.sentryc.marketplaces.repos.MarketPlaceRepo;
import com.sentryc.marketplaces.repos.ProducerRepo;
import com.sentryc.marketplaces.repos.SellerInfoRepo;
import com.sentryc.marketplaces.repos.SellerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log
public class SellerService {

    private final SellerRepo sellerRepo;
    private final SellerInfoRepo sellerInfoRepo;

    public Page<Seller> findByPageAndSize(int page, int size) {
        PageRequest request = PageRequest.of(page, size);
        return sellerRepo.findAll(request);
    }

    public SellerInfo searchSellerByName(String sellerName) {
        SellerInfo info = sellerInfoRepo.findSellerInfoByName(sellerName);
        if (info.getId() == null) {
            throw new RuntimeException("Seller does not exist");
        }
        return info;
    }

    public Page<SellerInfo> getSellerInfoWithSortDirection(int page, int size,
                                                           SortValues sortValue,
                                                           Sort.Direction direction) {
        PageRequest request = null;
        if (direction.isAscending()) {
            request = PageRequest.of(page, size, Sort.by(sortValue.getText()).ascending());
        } else if (direction.isDescending()) {
            request = PageRequest.of(page, size, Sort.by(sortValue.getText()).descending());
        }
        Objects.requireNonNull(request);
        return sellerInfoRepo.findAll(request);
    }

    public List<PagebleResponse> getAllSellerData() {
        List<Seller> sellerListed = sellerRepo.findAll();
        Objects.requireNonNull(sellerListed);
        return sellerListed.stream().map(v -> new PagebleResponse(v.getSellerInfo().getName(),
                v.getSellerInfo().getExternalId(), v.getSellerInfo().getMarketPlace().getId(),
                List.of(new ProducerSellerInfo(v.getProducer().getId().toString(),
                        v.getProducer().getName(), v.getState(), v.getId().toString())))).toList();
    }

    public enum SortValues {
        EXTERNAL_ID("externalId"), NAME("name"), MARKETPLACE_ID("marketPlace");

        private String text;

        SortValues(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
