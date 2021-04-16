package com.gustavo.inditex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class InditexApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void priceInfoControllerTest() throws Exception {

        mvc.perform(get("/get-price?current-date=2020-06-14 10:00:00&brand-id=1&product-id=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product-id", is(35455)))
                .andExpect(jsonPath("$.brand-id", is(1)))
                .andExpect(jsonPath("$.start-date", lessThan("2020-06-14 10:00:00")))
                .andExpect(jsonPath("$.end-date", greaterThan("2020-06-14 10:00:00")))
                .andExpect(status().isOk());

        mvc.perform(get("/get-price?current-date=2020-06-14 16:00:00&brand-id=1&product-id=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product-id", is(35455)))
                .andExpect(jsonPath("$.brand-id", is(1)))
                .andExpect(jsonPath("$.start-date", lessThan("2020-06-14 16:00:00")))
                .andExpect(jsonPath("$.end-date", greaterThan("2020-06-14 16:00:00")))
                .andExpect(status().isOk());

        mvc.perform(get("/get-price?current-date=2020-06-14 21:00:00&brand-id=1&product-id=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product-id", is(35455)))
                .andExpect(jsonPath("$.brand-id", is(1)))
                .andExpect(jsonPath("$.start-date", lessThan("2020-06-14 21:00:00")))
                .andExpect(jsonPath("$.end-date", greaterThan("2020-06-14 21:00:00")))
                .andExpect(status().isOk());

        mvc.perform(get("/get-price?current-date=2020-06-15 10:00:00&brand-id=1&product-id=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product-id", is(35455)))
                .andExpect(jsonPath("$.brand-id", is(1)))
                .andExpect(jsonPath("$.start-date", lessThan("2020-06-15 10:00:00")))
                .andExpect(jsonPath("$.end-date", greaterThan("2020-06-15 10:00:00")))
                .andExpect(status().isOk());

        mvc.perform(get("/get-price?current-date=2020-06-16 21:00:00&brand-id=1&product-id=35455")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.product-id", is(35455)))
                .andExpect(jsonPath("$.brand-id", is(1)))
                .andExpect(jsonPath("$.start-date", lessThan("2020-06-16 21:00:00")))
                .andExpect(jsonPath("$.end-date", greaterThan("2020-06-16 21:00:00")))
                .andExpect(status().isOk());


    }

}
