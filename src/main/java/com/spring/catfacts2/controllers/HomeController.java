package com.spring.catfacts2.controllers;

import com.spring.catfacts2.services.GetCatFactsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller

public class HomeController {

    GetCatFactsService cfs = new GetCatFactsService();

    @GetMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to Cat Facts! Here after are the URLs that you can use: " +
                "\n .../getSingle --> to read one single random fact about cats" +
                "\n .../getTen --> to read 10 random facts about cats" +
                "\n .../getTenSortedByDate --> to read 10 random facts about cats, sorted by creation date" +
                "\n .../contains?letter=[YOUR LETTER]&number=[YOUR NUMBER] --> to read one random fact about cats, if the letter" +
                "\n (replace it with your own) is contained a number (replace it with your own) of times.";
    }

    @GetMapping("/getSingle")
    @ResponseBody
    public String singleFacts() throws IOException {
        return cfs.getSingle();
    }

    @GetMapping("/getTen")
    @ResponseBody
    public String getTenFacts() throws IOException {
        return cfs.getTen();
    }
    @GetMapping("/getTenSortedByDate")
    @ResponseBody
    public String getTenFactsSortedByDate() throws IOException {
        return cfs.getTenSortByDate();
    }
    @GetMapping("/contains")
    @ResponseBody
    public String contains(@RequestParam char letter, @RequestParam int number) throws IOException {
     return cfs.getParamCF(letter, number);
    }
}
