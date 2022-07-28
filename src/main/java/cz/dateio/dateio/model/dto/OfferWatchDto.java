package cz.dateio.dateio.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class OfferWatchDto {
    Long clientId;
    Long offerId;
    Date lastWatch;

    public OfferWatchDto() {
    }

    public OfferWatchDto(Long clientId, Long offerId, Date lastWatch) {
        this.clientId = clientId;
        this.offerId = offerId;
        this.lastWatch = lastWatch;
    }
}
