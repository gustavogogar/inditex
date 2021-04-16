package com.gustavo.inditex.repository;

import com.gustavo.inditex.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("priceInfoRepository")
public interface PriceInfoRepository extends CrudRepository<PriceEntity, Long> {

    PriceEntity findFirstByStartDateBeforeAndEndDateAfterAndBrandIdAndProductIdOrderByPriorityDesc(Date currentDateStart, Date currentDateEnd, Long brandId, Long productId);
}
