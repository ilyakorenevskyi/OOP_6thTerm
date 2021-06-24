package com.ilyakor.lab2.service;

import com.ilyakor.lab2.dto.SubscriptionRequest;
import com.ilyakor.lab2.entity.Subscription;
import com.ilyakor.lab2.repository.ClientRepo;
import com.ilyakor.lab2.repository.PeriodicalRepo;
import com.ilyakor.lab2.repository.SubscriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepo subsRepo;

    @Autowired
    private ClientRepo clientRepo;

    @Autowired
    private PeriodicalRepo periodicalRepo;

    public List<Subscription> getAllSubs(){
        List<Subscription> subs;
        subs = (ArrayList<Subscription>) subsRepo.findAll();
        return subs;
    }

    public Subscription addSub(SubscriptionRequest sub){
        Subscription subscription = new Subscription();
        subscription.setClient(clientRepo.findById(sub.getClientId()).get());
        subscription.setPeriodical(periodicalRepo.findById(sub.getPeriodicalId()).get());
        subscription.setStatus(true);
        subscription.setPeriod(sub.getPeriod());
        subscription.setStartDate(sub.getStartDate());
        return subsRepo.save(subscription);
    }
}
