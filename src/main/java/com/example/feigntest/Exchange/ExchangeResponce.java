package com.example.feigntest.Exchange;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class ExchangeResponce {

    @SerializedName("rates")
    public Map<String,Number> rates = new HashMap();


    public Map<String,Number> getRates() {
        return rates;
    }
}
