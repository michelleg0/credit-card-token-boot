package com.sdk.creditcardtokenboot.service;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import com.sdk.creditcardtokenboot.repository.CreditCardRepository;
import org.springframework.stereotype.Service;
import java.util.List;


//create a method to get credit card csv. This method calls the repository class
//capture transformation. This will be where you change into a csv format. Then return that csv file back to a controller. May need to open a stream
//Any complex logic will need to be on the service layer
//Repository is just for the database
//The browser may prompt a download

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
        return creditCardRepository.findById(id);
    }

    public void deleteCreditCard(int id) {
        creditCardRepository.delete(id);
    }
}
