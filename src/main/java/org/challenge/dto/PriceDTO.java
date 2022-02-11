package org.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

    private int brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int priceList;

    private int productId;

    private int priority;

    private BigDecimal price;

    private String curr;
}
