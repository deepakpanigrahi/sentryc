package com.sentryc.marketplaces.repos;

import com.sentryc.marketplaces.model.SellerInfo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerInfoRepo extends JpaRepository<SellerInfo, UUID> {
}
