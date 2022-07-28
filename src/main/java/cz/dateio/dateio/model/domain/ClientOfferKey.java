package cz.dateio.dateio.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ClientOfferKey implements Serializable {
    @Column(name = "client_id")
    Long clientId;

    @Column(name = "offer_id")
    Long offerId;

    public ClientOfferKey() {
    }

    public ClientOfferKey(Long clientId, Long offerId) {
        this.clientId = clientId;
        this.offerId = offerId;
    }
}
