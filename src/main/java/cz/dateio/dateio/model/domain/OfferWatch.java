package cz.dateio.dateio.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class OfferWatch {
    @EmbeddedId
    ClientOfferKey id;

    @ManyToOne
    @MapsId("clientId")
    @JoinColumn(name = "client_id")
    Client client;

    public OfferWatch() {
    }

    public OfferWatch(ClientOfferKey id, Date lastWatch) {
        this.id = id;
        this.lastWatch = lastWatch;
    }

    @ManyToOne
    @MapsId("offerId")
    @JoinColumn(name = "offer_id")
    Offer offer;

    @Column(nullable = false)
    Date lastWatch;
}
