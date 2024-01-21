package com.sentryc.marketplaces.repos;

import com.sentryc.marketplaces.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProducerRepo extends JpaRepository<Producer, UUID> {
}
