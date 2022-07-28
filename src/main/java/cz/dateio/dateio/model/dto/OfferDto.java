package cz.dateio.dateio.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OfferDto {
    Long id;

    String name;

    Date visibleFrom;

    Date visibleTo;

    String description;

    public OfferDto() {
    }

    public OfferDto(Long id, String name, Date visibleFrom, Date visibleTo, String description) {
        this.id = id;
        this.name = name;
        this.visibleFrom = visibleFrom;
        this.visibleTo = visibleTo;
        this.description = description;
    }
}
