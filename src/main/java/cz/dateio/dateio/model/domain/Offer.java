package cz.dateio.dateio.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Offer {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    Date visibleFrom;

    @Column(nullable = false)
    Date visibleTo;

    @Column(nullable = false,length = 3000)
    String description;

    @OneToMany(mappedBy = "offer")
    Set<OfferWatch> offerWatchSet;

    public Offer() {
    }

    public Offer(Long id, String name, Date visibleFrom, Date visibleTo, String description) {
        this.id = id;
        this.name = name;
        this.visibleFrom = visibleFrom;
        this.visibleTo = visibleTo;
        this.description = description;
    }
}
