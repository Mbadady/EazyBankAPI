package com.mbadady.EazyBank.controller;

import com.mbadady.EazyBank.entity.Cards;
import com.mbadady.EazyBank.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsService cardsService;

    @GetMapping("/cards")
    public List<Cards> getCardDetails(@RequestParam Long customerId){
        return cardsService.getCardDetails(customerId);
    }
}
