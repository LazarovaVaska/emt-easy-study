package com.finki.emt.subscriptionmenagement.service;

import com.finki.emt.subscriptionmenagement.domain.exceptions.SubscriptionIdNotExistException;
import com.finki.emt.subscriptionmenagement.domain.exceptions.SubscriptionItemIdNotExistException;
import com.finki.emt.subscriptionmenagement.domain.model.Subscription;
import com.finki.emt.subscriptionmenagement.domain.model.SubscriptionId;
import com.finki.emt.subscriptionmenagement.domain.model.SubscriptionItemId;
import com.finki.emt.subscriptionmenagement.service.forms.SubscriptionItemForm;
import com.finki.emt.subscriptionmenagement.service.forms.SubscriptionForm;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {

    //validation and checks are done in the service( application logic)
    public SubscriptionId getSubscription(SubscriptionForm subscriptionForm);

    public List<Subscription> findAll();

    public Optional<Subscription> findById(SubscriptionId subscriptionId);

    void addItem(SubscriptionId subscriptionId, SubscriptionItemForm subscriptionItemForm) throws SubscriptionIdNotExistException;

    void removeItem(SubscriptionId subscriptionId, SubscriptionItemId orderItemId) throws SubscriptionIdNotExistException, SubscriptionItemIdNotExistException;


}
