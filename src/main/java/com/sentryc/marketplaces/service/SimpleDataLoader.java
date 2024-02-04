package com.sentryc.marketplaces.service;

import com.github.javafaker.Faker;
import com.sentryc.marketplaces.model.*;
import com.sentryc.marketplaces.repos.SellerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;

@Component
@RequiredArgsConstructor
@Log
public class SimpleDataLoader implements CommandLineRunner {

    private final SellerRepo sellerRepo;
    private final Faker faker;

    @Override
    public void run(String... args) {
        log.info("Loading data");

        for (int i = 1; i < 100; i++) {
            MarketPlace marketPlace = new MarketPlace(
                    faker.app().name() + i,
                    faker.company().buzzword());
            SellerInfo sellerInfo = new SellerInfo(
                    faker.name().fullName(),
                    faker.internet().url(),
                    faker.country().name(),
                    faker.number().digits(6),
                    marketPlace);
            Producer producer = new Producer(
                    "Producer - " + i,
                    Timestamp.from(Instant.now()));
            Seller seller = new Seller(
                    producer,
                    sellerInfo,
                    State.getRandomState());
            Seller saved = sellerRepo.save(seller);
            log.info("saved seller - > " + saved.getSellerInfo().toString());
        }
        //log.info("Data loading complete");
    }
}
