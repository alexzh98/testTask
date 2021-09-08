package com.example.feigntest.clients;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Giph {
    @SerializedName("id")
    private String id;
    @SerializedName("embed_url")
    private String embedUrl;
    @SerializedName("url")
    private String url;
    @SerializedName("data")
    private String data;
}
