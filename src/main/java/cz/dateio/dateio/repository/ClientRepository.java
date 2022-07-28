package cz.dateio.dateio.repository;

import cz.dateio.dateio.model.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
