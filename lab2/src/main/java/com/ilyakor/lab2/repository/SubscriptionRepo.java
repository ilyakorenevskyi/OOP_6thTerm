package com.ilyakor.lab2.repository;

import com.ilyakor.lab2.entity.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription,Long> {
}
