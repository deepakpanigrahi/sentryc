package com.sentryc.marketplaces.repos;

import com.sentryc.marketplaces.model.Seller;
import com.sentryc.marketplaces.model.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SellerRepo extends JpaRepository<Seller, UUID> {
}
