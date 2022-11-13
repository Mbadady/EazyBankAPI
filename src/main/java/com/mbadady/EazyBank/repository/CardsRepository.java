package com.mbadady.EazyBank.repository;

import com.mbadady.EazyBank.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardsRepository extends JpaRepository<Cards, Long> {
   List<Cards> findByCustomerId(Long customerId);
}
