package com.example.feigntest.services;

import com.example.feigntest.FeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service
public class CurrencyServiceimpl implements CurrencyService {
private final static String appId="68fa045f62df46088c7657367f870f3f";
    @Autowired
    FeignClients feignClients;


    @Override
    public Number getCurrentExchangeRateForOneTicker(String ticker) {
        Map map = feignClients.getall(appId);

        Map <String,Number> ratesMap =(Map<String, Number>) map.get("rates");
        return ratesMap.get(ticker);

    }

    @Override
    public Number getYesterdayExchangeRateForOneTicker(String ticker) {
        LocalDate now = LocalDate.now();
        LocalDate yesterday = now.minusDays(1);

        Map map = feignClients.getHistoricalExchangeRate(appId,yesterday.toString());

        Map <String,Number> ratesMap =(Map<String, Number>) map.get("rates");
        return  ratesMap.get(ticker);

    }

    public Number getHistoricalExchangeRateForOneTicker(String ticker, String date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate d = LocalDate.parse(date);
        System.out.println(d);

        Map map = feignClients.getHistoricalExchangeRate(appId,d.toString());

        Map <String,Number> ratesMap =(Map<String, Number>) map.get("rates");
        return  ratesMap.get(ticker);


    }
}
