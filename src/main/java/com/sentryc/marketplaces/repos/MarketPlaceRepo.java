package com.sentryc.marketplaces.repos;

import com.sentryc.marketplaces.model.MarketPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketPlaceRepo extends JpaRepository<MarketPlace, String> {
}
