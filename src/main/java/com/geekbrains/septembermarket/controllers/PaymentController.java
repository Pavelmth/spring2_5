package com.geekbrains.septembermarket.controllers;

import com.geekbrains.septembermarket.entities.Order;
import com.geekbrains.septembermarket.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    private OrderRepository orderRepository;

    @Autowired
    public void setOrder(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping()
    public String showPayment(Principal principal, Model model, @RequestParam(name = "id") Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = optional.get();
        String str = order.getUser().getPhone();
        model.addAttribute("order", order);
        return "payment";
    }
}
