package com.example.feigntest.clients;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GiphData {
    @SerializedName("id")
    String id;
    @SerializedName("url")
    String url;
    @SerializedName("embed_url")
    String embed_url;

}
