package com.example.feigntest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;

@FeignClient(name = "exchanged-service",url ="https://openexchangerates.org/api")
public interface FeignClients {


    @RequestMapping(value = "/latest.json?app_id={app_id}")
     Map getall(@PathVariable(name = "app_id") String appId);


    @RequestMapping(value = "/historical/{date}.json?app_id={app_id}")
     Map getHistoricalExchangeRate(@PathVariable(name = "app_id") String appID,
                                  @PathVariable(name = "date") String date);


}
