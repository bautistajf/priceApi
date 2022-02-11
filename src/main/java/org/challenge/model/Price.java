package org.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.challenge.configuration.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id")
    private Long priceId;

    @NotNull
    @Column(name = "brand_id")
    private int brandId;

    @NotNull
    @Column(name = "start_date")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "end_date")
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime endDate;

    @NotNull
    @Column(name = "price_list")
    private int priceList;

    @NotNull
    @Column(name = "product_id")
    private int productId;

    @NotNull
    @Column(name = "priority")
    private int priority;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    @Column(name = "curr")
    private String curr;

}
