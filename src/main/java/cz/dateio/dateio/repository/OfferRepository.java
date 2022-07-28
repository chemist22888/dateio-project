package cz.dateio.dateio.repository;

import cz.dateio.dateio.model.domain.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
