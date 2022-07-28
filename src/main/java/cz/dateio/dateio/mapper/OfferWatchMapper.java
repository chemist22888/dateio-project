package cz.dateio.dateio.mapper;

import cz.dateio.dateio.model.domain.ClientOfferKey;
import cz.dateio.dateio.model.domain.OfferWatch;
import cz.dateio.dateio.model.dto.OfferWatchDto;
import org.springframework.stereotype.Component;

@Component
public class OfferWatchMapper {
    public OfferWatchDto toDto(OfferWatch offerWatch) {
        if (offerWatch == null)
            return null;
        OfferWatchDto dto =
                new OfferWatchDto(offerWatch.getId().getClientId(), offerWatch.getId().getOfferId(), offerWatch.getLastWatch());

        return dto;
    }

    public OfferWatch toOfferWatch(OfferWatchDto offerWatchDto) {
        if(offerWatchDto == null)
            return null;
        OfferWatch offerWatch =
                new OfferWatch(new ClientOfferKey(offerWatchDto.getClientId(), offerWatchDto.getOfferId()), offerWatchDto.getLastWatch());

        return offerWatch;

    }
}
