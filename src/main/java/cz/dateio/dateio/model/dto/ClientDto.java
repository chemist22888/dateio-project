package cz.dateio.dateio.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Getter
@Setter
public class ClientDto {
    Long id;

    Long bankId;

    public ClientDto(Long id, Long bankId, String uuid, Date registrationTime) {
        this.id = id;
        this.bankId = bankId;
        this.uuid = uuid;
        this.registrationTime = registrationTime;
    }

    public ClientDto() {
    }

    String uuid;

    Date registrationTime;

}
