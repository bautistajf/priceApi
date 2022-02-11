package org.challenge.service;

import javassist.NotFoundException;
import org.challenge.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface PriceService {

    Price getPrice(final LocalDateTime applicationDate, int productId, int brandId) throws NotFoundException;
}
