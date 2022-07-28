package cz.dateio.dateio.repository;

import cz.dateio.dateio.model.domain.ClientOfferKey;
import cz.dateio.dateio.model.domain.OfferWatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferWatchRepository extends JpaRepository<OfferWatch, ClientOfferKey> {
//    boolean existsById(ClientOfferKey id);
}
