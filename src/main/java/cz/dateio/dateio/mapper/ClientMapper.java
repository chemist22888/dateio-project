package cz.dateio.dateio.mapper;

import cz.dateio.dateio.model.domain.Client;
import cz.dateio.dateio.model.dto.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    public ClientDto toDto(Client client) {
        if(client == null)
            return null;
        ClientDto dto =
                new ClientDto(client.getId(),  client.getBankId(),
                        client.getUuid(), client.getRegistrationTime());
        return dto;
    }

    public Client toCustomer(ClientDto clientDto) {
        if(clientDto == null)
            return null;
        Client client =
                new Client(clientDto.getId(),clientDto.getBankId(),
                        clientDto.getUuid(), clientDto.getRegistrationTime());
        return client;
    }
}
