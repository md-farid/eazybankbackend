package com.teamwebsoft.controllers;

import com.teamwebsoft.models.Cards;
import com.teamwebsoft.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    @Autowired
    private CardsRepository cardsRepository;

    public List<Cards> getCardsDetails(@RequestParam long id){
        List<Cards> cards = cardsRepository.findByCustomerId(id);
        if(cards != null){
            return cards;
        }
        else{
            return null;
        }
    }

}
