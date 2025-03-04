package com.sdk.creditcardtokenboot.service;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import com.sdk.creditcardtokenboot.repository.CreditCardRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CreditCardService {
    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public CreditCard getCreditCardById(int id) {
        return null;
    }
}
