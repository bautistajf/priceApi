package org.challenge.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.challenge.util.ControllerHelper.PRICE_CONTROLLER_PATH;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void callGetPriceShouldReturnValue1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PRICE_CONTROLLER_PATH)
                        .param("applicationDate", "2020-06-14T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.priceList", equalTo(1)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.priority", equalTo(0)))
                .andExpect(jsonPath("$.price", equalTo(35.5)))
                .andExpect(jsonPath("$.curr", equalTo("EUR")));
    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void callGetPriceShouldReturnValue2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PRICE_CONTROLLER_PATH)
                        .param("applicationDate", "2020-06-14T16:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-14T15:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-06-14T18:30:00")))
                .andExpect(jsonPath("$.priceList", equalTo(2)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.priority", equalTo(1)))
                .andExpect(jsonPath("$.price", equalTo(25.45)))
                .andExpect(jsonPath("$.curr", equalTo("EUR")));
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    void callGetPriceShouldReturnValue3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PRICE_CONTROLLER_PATH)
                        .param("applicationDate", "2020-06-14T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.priceList", equalTo(1)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.priority", equalTo(0)))
                .andExpect(jsonPath("$.price", equalTo(35.5)))
                .andExpect(jsonPath("$.curr", equalTo("EUR")));
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    void callGetPriceShouldReturnValue4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PRICE_CONTROLLER_PATH)
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-15T00:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-06-15T11:00:00")))
                .andExpect(jsonPath("$.priceList", equalTo(3)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.priority", equalTo(1)))
                .andExpect(jsonPath("$.price", equalTo(30.5)))
                .andExpect(jsonPath("$.curr", equalTo("EUR")));
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    void callGetPriceShouldReturnValue5() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(PRICE_CONTROLLER_PATH)
                        .param("applicationDate", "2020-06-15T21:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-15T16:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.priceList", equalTo(4)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.priority", equalTo(1)))
                .andExpect(jsonPath("$.price", equalTo(38.95)))
                .andExpect(jsonPath("$.curr", equalTo("EUR")));
    }
}
