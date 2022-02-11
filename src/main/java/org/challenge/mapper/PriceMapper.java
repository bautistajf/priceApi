package org.challenge.mapper;

import org.challenge.dto.PriceDTO;
import org.challenge.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceDTO toDTO(final Price price);

}
