package com.adidas.test.subscription.infrastructure.repositories;

import com.adidas.test.subscription.domain.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubsriptionRepository extends JpaRepository<Subscription, Long> {
}
