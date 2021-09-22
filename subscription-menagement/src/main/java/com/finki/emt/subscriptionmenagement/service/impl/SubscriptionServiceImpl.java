package com.finki.emt.subscriptionmenagement.service.impl;


import com.finki.emt.sharedkernel.domain.events.subscription.SubscriptionItemCreated;
import com.finki.emt.sharedkernel.infra.DomainEventPublisher;
import com.finki.emt.subscriptionmenagement.domain.exceptions.SubscriptionIdNotExistException;
import com.finki.emt.subscriptionmenagement.domain.exceptions.SubscriptionItemIdNotExistException;
import com.finki.emt.subscriptionmenagement.domain.model.Subscription;
import com.finki.emt.subscriptionmenagement.domain.model.SubscriptionId;
import com.finki.emt.subscriptionmenagement.domain.model.SubscriptionItemId;
import com.finki.emt.subscriptionmenagement.domain.repository.SubscriptionRepository;
import com.finki.emt.subscriptionmenagement.service.SubscriptionService;
import com.finki.emt.subscriptionmenagement.service.forms.SubscriptionForm;
import com.finki.emt.subscriptionmenagement.service.forms.SubscriptionItemForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Transactional
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    //creating subscription for the ad
    @Override
    public SubscriptionId getSubscription(SubscriptionForm orderForm) {
        Objects.requireNonNull(orderForm, "order must not be null.");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }
        var newSubscription = subscriptionRepository.saveAndFlush(toDomainObject(orderForm));
        newSubscription.getSubscriptionItemList().forEach(item -> domainEventPublisher.publish(new SubscriptionItemCreated(item.getAdId().getId())));
        return newSubscription.getId();
    }

    @Override
    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    @Override
    public Optional<Subscription> findById(SubscriptionId id) {
        return subscriptionRepository.findById(id);
    }

    @Override
    public void addItem(SubscriptionId orderId, SubscriptionItemForm orderItemForm) throws SubscriptionItemIdNotExistException {
        Subscription order = subscriptionRepository.findById(orderId).orElseThrow(SubscriptionIdNotExistException::new);
        order.addItem(orderItemForm.getAd());
        subscriptionRepository.saveAndFlush(order);
        domainEventPublisher.publish(new SubscriptionItemCreated(orderItemForm.getAd().getId().getId()));
    }

    @Override
    public void removeItem(SubscriptionId orderId, SubscriptionItemId orderItemId) throws SubscriptionIdNotExistException, SubscriptionItemIdNotExistException {
        Subscription order = subscriptionRepository.findById(orderId).orElseThrow(SubscriptionIdNotExistException::new);
        order.removeItem(orderItemId);
        subscriptionRepository.saveAndFlush(order);
    }

    private Subscription toDomainObject(SubscriptionForm orderForm) {
        var order = new Subscription(Instant.now(), orderForm.getCurrency());
        orderForm.getItems().forEach(item -> order.addItem(item.getAd()));
        return order;
    }

}
