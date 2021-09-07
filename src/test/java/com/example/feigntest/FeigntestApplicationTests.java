package com.example.feigntest;
import static org.springframework.test.util.AssertionErrors.*;
import com.example.feigntest.contollers.appController;
import com.example.feigntest.services.CurrencyService;
import com.example.feigntest.services.CurrencyServiceimpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class FeigntestApplicationTests {
    @Autowired
    private appController controller;
    @Autowired
    private  CurrencyService service;
    private final String appId = "68fa045f62df46088c7657367f870f3f";


    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }


    @Test
    public void checkReturnedCurrency() {
        List<allEndpoints> endList = Arrays.asList(allEndpoints.values());
        endList.forEach(o->{
            float curr= service.getCurrentExchangeRateForOneTicker(o.toString()).floatValue();
            float yesterday = service.getYesterdayExchangeRateForOneTicker(o.toString()).floatValue();
            assertTrue("must be greater than zero",curr>=0f);
            assertTrue("must be greater than zero",yesterday>=0f);
            System.out.printf("%s: curr = %f, yesterday=%f",o.toString(),curr,yesterday);
            System.out.println();

        });
    }
}