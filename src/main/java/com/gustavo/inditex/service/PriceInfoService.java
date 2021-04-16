package com.gustavo.inditex.service;

import com.gustavo.inditex.dto.PriceDTO;
import com.gustavo.inditex.entity.PriceEntity;
import com.gustavo.inditex.repository.PriceInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("priceInfoService")
public class PriceInfoService {

    @Autowired
    PriceInfoRepository repository;

    public PriceDTO getProductInfo(Date currentDate, long productId, long brandId) {

        ModelMapper modelMapper = new ModelMapper();

        PriceEntity price = repository.findFirstByStartDateBeforeAndEndDateAfterAndBrandIdAndProductIdOrderByPriorityDesc(currentDate, currentDate, brandId, productId);

        return modelMapper.map(price, PriceDTO.class);
    }
}
