package cz.dateio.dateio.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue
    Long id;


    @Column
    Long bankId;

    @Column
    String uuid;

    @Column()
    Date registrationTime;

    @OneToMany(mappedBy = "client")
    Set<OfferWatch> offerWatchSet;

    public Client(Long id, Long bankId, String uuid, Date registrationTime) {
        this.id = id;
        this.bankId = bankId;
        this.uuid = uuid;
        this.registrationTime = registrationTime;
    }

    public Client() {
    }
}
