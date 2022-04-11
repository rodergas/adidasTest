package com.adidas.test.subscription.infrastructure.repositories;

import com.adidas.test.subscription.domain.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
}
