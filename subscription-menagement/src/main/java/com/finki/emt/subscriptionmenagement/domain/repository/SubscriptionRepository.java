package com.finki.emt.subscriptionmenagement.domain.repository;

import com.finki.emt.subscriptionmenagement.domain.model.Subscription;
import com.finki.emt.subscriptionmenagement.domain.model.SubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {

}