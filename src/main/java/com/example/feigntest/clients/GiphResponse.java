package com.example.feigntest.clients;

import com.google.gson.annotations.SerializedName;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;

public class GiphResponse {
    @SerializedName("data")
    GiphData data;

    public GiphData getData() {
        return data;
    }
}
