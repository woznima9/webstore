package com.packt.webstore.controller;

import com.packt.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/P1237/2")
    public String process() {
        orderService.processOrder("P1237", 5);
        return "redirect:/products";
    }
}
