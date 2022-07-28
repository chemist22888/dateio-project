package cz.dateio.dateio.service;

import cz.dateio.dateio.exception.BadDateOfferException;
import cz.dateio.dateio.exception.ClientNotFoundException;
import cz.dateio.dateio.exception.OfferNotFoundException;
import cz.dateio.dateio.mapper.OfferWatchMapper;
import cz.dateio.dateio.model.domain.Client;
import cz.dateio.dateio.model.domain.ClientOfferKey;
import cz.dateio.dateio.model.domain.Offer;
import cz.dateio.dateio.model.domain.OfferWatch;
import cz.dateio.dateio.model.dto.OfferWatchDto;
import cz.dateio.dateio.repository.ClientRepository;
import cz.dateio.dateio.repository.OfferRepository;
import cz.dateio.dateio.repository.OfferWatchRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OfferRepository offerRepository;
    @Autowired
    OfferWatchRepository offerWatchRepository;
    @Autowired
    OfferWatchMapper offerWatchMapper;
    @Override
    public OfferWatchDto addOfferWatch(Long clientId, Long offerId) throws Exception {

        Client client = clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        Offer offer = offerRepository.findById(offerId).orElseThrow(OfferNotFoundException::new);

        OfferWatch offerWatch = new OfferWatch(new ClientOfferKey(clientId,offerId),new Date());
        offerWatch.setClient(client);
        offerWatch.setOffer(offer);

        Date currentDate = new Date();
        if(!currentDate.after(offer.getVisibleFrom()) || !currentDate.before(offer.getVisibleTo()))
            throw new BadDateOfferException();

        return offerWatchMapper.toDto(offerWatchRepository.save(offerWatch));

    }


}
