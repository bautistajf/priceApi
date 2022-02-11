package org.challenge.repository;

import org.challenge.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime applicationDateFrom,
                                                                                                                         LocalDateTime applicationDateTo,
                                                                                                                         int productId,
                                                                                                                         int brandId);
}
