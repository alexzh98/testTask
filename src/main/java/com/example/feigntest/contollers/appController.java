package com.example.feigntest.contollers;

import com.example.feigntest.RequesterService.Requester;
import com.example.feigntest.clients.Giph;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class appController {

    @GetMapping("/{ticker}")
    public String mainPage(Model model,
                           @PathVariable(name = "ticker")String ticker){
        Giph giph = Requester.getGiph(ticker);
        model.addAttribute("embed_url",giph.getEmbedUrl());
        model.addAttribute("url",giph.getUrl());
        return "index";
    }

}