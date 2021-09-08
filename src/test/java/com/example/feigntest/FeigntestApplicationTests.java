package com.example.feigntest;
import com.example.feigntest.RequesterService.Requester;
import com.example.feigntest.clients.Giph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class FeigntestApplicationTests {

    @Test
    public void checkGifUrl(){
        List<allEndpoints>endpoints = new ArrayList<allEndpoints>(Arrays.asList(allEndpoints.values()));

        endpoints.forEach(o->{
            System.out.println("ticker: "+o.toString());
            Giph giph = Requester.getGiph(o.toString());
            String url= giph.getUrl();
            String embedUrl = giph.getEmbedUrl();
            assert(url!=null);
            System.out.println("url: "+url);
            assert(embedUrl!=null);
            System.out.println("embedUrl: "+embedUrl);
            float todayRate = Requester.getTodayRate();
            float yesterday=Requester.getYesterdayRate();
            assert(todayRate!=0);
            System.out.println("today Rate: "+todayRate);
            assert(yesterday!=0);
            System.out.println("yesterday Rate: "+yesterday);
            System.out.println("==========================================");

        });

        }
    }
