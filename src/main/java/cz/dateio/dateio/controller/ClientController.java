package cz.dateio.dateio.controller;

import cz.dateio.dateio.exception.BadDateOfferException;
import cz.dateio.dateio.exception.ClientNotFoundException;
import cz.dateio.dateio.exception.OfferNotFoundException;
import cz.dateio.dateio.model.dto.OfferWatchDto;
import cz.dateio.dateio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @ExceptionHandler(ClientNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String clientNotFound(){
        return "Client with this ID not found";
    }
    @ExceptionHandler(OfferNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String offerNotFound(){
        return "Offer with this ID not found";
    }
    @ExceptionHandler(BadDateOfferException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badDate(){
        return "Offer is not visible at this time";
    }

    @Autowired
    ClientService clientService;

    @PostMapping("/watch")
    public OfferWatchDto watchOffer(@RequestParam("clientId") Long clientId,
                                    @RequestParam("offerId") Long offerId,
                                    @RequestParam("bankId") Long bankId) throws Exception {

       return clientService.addOfferWatch(clientId,offerId);
    }
}
