package com.mbadady.EazyBank.service;

import com.mbadady.EazyBank.entity.Cards;
import com.mbadady.EazyBank.repository.CardsRepository;

import java.util.List;

public interface CardsService {

    List<Cards> getCardDetails(Long customerId);

}
