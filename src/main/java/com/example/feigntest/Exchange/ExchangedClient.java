package com.example.feigntest.Exchange;
import feign.Param;
import feign.RequestLine;


public interface ExchangedClient {


     @RequestLine("GET /latest.json?app_id={app_id}")
     ExchangeResponce getCurentExchangeRate(@Param("app_id") String appId);


     @RequestLine("GET /historical/{date}.json?app_id={app_id}")
     ExchangeResponce getHistoricalExchangeRate(@Param("app_id") String appID,
                                                @Param("date") String date);


}
