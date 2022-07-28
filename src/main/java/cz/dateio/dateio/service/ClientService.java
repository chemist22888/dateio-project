package cz.dateio.dateio.service;

import cz.dateio.dateio.exception.ClientNotFoundException;
import cz.dateio.dateio.model.domain.OfferWatch;
import cz.dateio.dateio.model.dto.OfferWatchDto;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface ClientService {
    OfferWatchDto addOfferWatch(Long clientId, Long offerId) throws Exception;
}
