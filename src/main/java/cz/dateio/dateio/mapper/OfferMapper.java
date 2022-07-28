package cz.dateio.dateio.mapper;

import cz.dateio.dateio.model.domain.Offer;
import cz.dateio.dateio.model.dto.OfferDto;
import org.springframework.stereotype.Component;

@Component
public class OfferMapper {
    public OfferDto toDto(Offer offer) {
        if(offer == null)
            return null;
        OfferDto dto =
                new OfferDto(offer.getId(), offer.getName(),
                offer.getVisibleFrom(), offer.getVisibleTo(), offer.getDescription());

        return dto;
    }

    public Offer toOffer(OfferDto offerDto) {
        if(offerDto == null)
            return null;
        Offer offer =
                new Offer(offerDto.getId(), offerDto.getName(),
                        offerDto.getVisibleFrom(), offerDto.getVisibleTo(), offerDto.getDescription());

        return offer;
    }
}
