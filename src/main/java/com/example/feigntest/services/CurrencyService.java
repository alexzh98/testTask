package com.example.feigntest.services;

public interface CurrencyService {


    public Number getCurrentExchangeRateForOneTicker(String ticker);
    public Number getYesterdayExchangeRateForOneTicker(String ticker);
    public Number getHistoricalExchangeRateForOneTicker(String ticker, String date);

}
