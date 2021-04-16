package com.gustavo.inditex.controller;

import com.gustavo.inditex.dto.PriceDTO;
import com.gustavo.inditex.service.PriceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;


@Controller
public class PriceInfoController {

    @Autowired
    PriceInfoService priceInfoService;

    /**
     * Return Price info by
     * @param currentDate http request datetime
     * @param productId id product
     * @param brandId id brand
     */
    @GetMapping(value = "/get-price")
    @ResponseBody
    public PriceDTO getPriceInfo(@RequestParam(value = "current-date") Timestamp currentDate,
                                             @RequestParam(value = "product-id") long productId,
                                             @RequestParam(value = "brand-id") long brandId) {

        return priceInfoService.getProductInfo(currentDate, productId, brandId);
    }
}
