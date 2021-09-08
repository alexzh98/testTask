package com.example.feigntest.clients;

import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestParam;


public interface GiphyClient {

    @RequestLine("GET ?api_key={api_key}&tag=rich")
    public GiphResponse getRichGif(@Param("api_key") String apiKey);

    @RequestLine("GET ?api_key={api_key}&tag=broke")
    public GiphResponse getBrokeGif(@Param("api_key") String apiKey);
}
