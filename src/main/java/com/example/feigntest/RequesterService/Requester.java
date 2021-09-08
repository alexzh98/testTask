package com.example.feigntest.RequesterService;

import com.example.feigntest.Exchange.ExchangeResponce;
import com.example.feigntest.Exchange.ExchangedClient;
import com.example.feigntest.clients.Giph;
import com.example.feigntest.clients.GiphData;
import com.example.feigntest.clients.GiphResponse;
import com.example.feigntest.clients.GiphyClient;
import feign.Feign;
import feign.gson.GsonDecoder;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


public class Requester {

private static String viaGiphy_key;
private static String openExchange_key;
private static ExchangeResponce exchangeResponceToday;
private static ExchangeResponce exchangeResponceYesterday;
private static GiphResponse giphResponse;
private static float yesterdayRate;
private static float todayRate;

private static GiphyClient giphyClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(GiphyClient.class, "https://api.giphy.com/v1/gifs/random");

private static ExchangedClient exchangedClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(ExchangedClient.class, "https://openexchangerates.org/api");
    static {
    Properties properties = new Properties();
    try (FileInputStream fis = new FileInputStream("src/main/resources/prop/api_keys.properties")){
        properties.load(fis);
        openExchange_key=properties.getProperty("open-exchanger-api-id");
        viaGiphy_key=properties.getProperty("via-giphy-api-key");
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public  static  Giph getGiph(String ticker){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        exchangeResponceToday=exchangedClient.getCurentExchangeRate(openExchange_key);
        exchangeResponceYesterday = exchangedClient.getHistoricalExchangeRate(openExchange_key,yesterday.format(formatter));
        yesterdayRate = exchangeResponceYesterday.getRates().get(ticker).floatValue();
        todayRate = exchangeResponceToday.getRates().get(ticker).floatValue();

        float range = todayRate-yesterdayRate;
        if(range>=0){
            giphResponse = giphyClient.getRichGif(viaGiphy_key);
        }
        else giphResponse=giphyClient.getBrokeGif(viaGiphy_key);
        GiphData data = giphResponse.getData();
        Giph giph = new Giph();
        giph.setEmbedUrl(data.getEmbed_url());
        giph.setUrl(data.getUrl());
        return  giph;
    }

    public static float getYesterdayRate() {
        return yesterdayRate;
    }

    public static float getTodayRate() {
        return todayRate;
    }
}
