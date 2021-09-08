package com.example.feigntest;
import com.example.feigntest.RequesterService.Requester;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Locale;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//@WebMvcTest
//@AutoConfigureMockMvc
//public class ControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    WebApplicationContext webApplicationContext;
//
//
//@Test
//    public void checkGif(){
//        List<allEndpoints> endpoints = Arrays.asList(allEndpoints.values());
//        endpoints.forEach(o->{
//            String endp = o.toString().toUpperCase(Locale.ROOT).trim();
//            String er = "";
//            System.out.println(endp);
//            try {
//                mockMvc.perform(get("/"+o.toString().toUpperCase(Locale.ROOT))).andExpect(status().isOk())
//                                .andExpect(xpath("//frame[@srs='"+er+"']").doesNotExist());
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//}
