package com.sdk.creditcardtokenboot.controller;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import com.sdk.creditcardtokenboot.service.CreditCardService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creditcards")
public class CreditCardController {
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/{id}")
    public CreditCard getCreditCardById(@PathVariable int id) {
        return creditCardService.getCreditCardById(id);
    }

    @PostMapping
    public void addCreditCard(@RequestBody CreditCard creditCard) {
        creditCardService.addCreditCard(creditCard);
    }

    @PutMapping("/{id}")
    public void updateCreditCard(@PathVariable int id, @RequestBody CreditCard creditCard) {
        creditCard.setId(id);
        creditCardService.updateCreditCard(creditCard);
    }

    @DeleteMapping("/{id}")
    public void deleteCreditCard(@PathVariable int id) {
        creditCardService.deleteCreditCard(id);
    }
}
