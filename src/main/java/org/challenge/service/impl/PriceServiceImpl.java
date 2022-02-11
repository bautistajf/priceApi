package org.challenge.service.impl;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.challenge.model.Price;
import org.challenge.repository.PriceRepository;
import org.challenge.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    @Override
    public Price getPrice(final LocalDateTime applicationDate, int productId, int brandId) throws NotFoundException {
        Optional<Price> result = priceRepository.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, applicationDate, productId, brandId);

        return result.orElseThrow(() ->
                new NotFoundException(format("No existe precio para la fecha %s, con productId: %s y brandId: %s",
                        applicationDate, productId, brandId)));
    }
}
