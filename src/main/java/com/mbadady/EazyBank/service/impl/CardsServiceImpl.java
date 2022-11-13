package com.mbadady.EazyBank.service.impl;

import com.mbadady.EazyBank.entity.Cards;
import com.mbadady.EazyBank.repository.CardsRepository;
import com.mbadady.EazyBank.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardsServiceImpl implements CardsService {

    private CardsRepository cardsRepository;

    @Autowired
    public CardsServiceImpl(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @Override
    public List<Cards> getCardDetails(Long customerId) {
        List<Cards> card = cardsRepository.findByCustomerId(customerId);

        if(card != null){
            return card;
        }else{
            return null;
        }
    }
}
