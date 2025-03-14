package com.sdk.creditcardtokenboot.controller;

import com.sdk.creditcardtokenboot.entity.CreditCard;
import com.sdk.creditcardtokenboot.service.CreditCardService;
import java.util.List;
import org.springframework.web.bind.annotation.*;


//get request, since we are pulling date to a csv file controller - endpoint. Adds to csv file
//from the controller we are going to a service class, where this will talk to a repository class.
//the front end will also require another controller. That controller will have a get request ("/")
//model view controller. The controller is the starting point


//when springboot starts it is looking for this controller. It'll look at these two files, then go from there
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

    @GetMapping("/creditcardid/{id}")
    public CreditCard getCreditCardById(@PathVariable int id) {
        return creditCardService.getCreditCardById(id);
    }


}
