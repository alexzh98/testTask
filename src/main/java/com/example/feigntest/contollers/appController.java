package com.example.feigntest.contollers;
import com.example.feigntest.FeignClients;
import com.example.feigntest.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {

    @Autowired
    FeignClients feignClients;

    @Autowired
    CurrencyService service;

        @GetMapping("/currency")
    public @ResponseBody
        ResponseEntity<?> getCurrencyRate(@RequestParam("ticker")String ticker){
        return new ResponseEntity<>(service.getCurrentExchangeRateForOneTicker(ticker), HttpStatus.OK);
    }
        @GetMapping("/yesterday")
    public @ResponseBody
    ResponseEntity<?> getYesterdayRate(@RequestParam("ticker") String ticker){
            return new ResponseEntity<>(service.getYesterdayExchangeRateForOneTicker(ticker),HttpStatus.OK);
    }
        @GetMapping("/historical")
    public @ResponseBody
    ResponseEntity<?> getHistoricalRate(@RequestParam("ticker")String ticker,
                                        @RequestParam("date")String date){
            return new ResponseEntity<>(service.getHistoricalExchangeRateForOneTicker(ticker,date),HttpStatus.OK);
    }
}
