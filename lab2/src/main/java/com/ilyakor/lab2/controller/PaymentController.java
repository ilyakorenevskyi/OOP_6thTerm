package com.ilyakor.lab2.controller;

import com.ilyakor.lab2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaymentController {
    @Autowired
    PaymentService paymentService;


}
