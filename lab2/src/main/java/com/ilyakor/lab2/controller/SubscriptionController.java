package com.ilyakor.lab2.controller;

import com.ilyakor.lab2.dto.SubscriptionRequest;
import com.ilyakor.lab2.entity.Subscription;
import com.ilyakor.lab2.repository.SubscriptionRepo;
import com.ilyakor.lab2.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subsService;

    @GetMapping
    public ResponseEntity<List<Subscription>> getSubs(){
        List<Subscription> subs = subsService.getAllSubs();
        return ResponseEntity.ok(subs);
    }

    @PostMapping
    public ResponseEntity<Subscription> addSub(@RequestBody SubscriptionRequest sub){
        Subscription newSub = subsService.addSub(sub);
        return ResponseEntity.ok(newSub);
    }


}
