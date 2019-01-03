package com.example.demo.controller;

import com.example.demo.models.ResultsContent;
import com.example.demo.services.DetectSensitiveKeywords;
import org.springframework.web.bind.annotation.*;

@RestController
//@Controller
public class AppController {

    String content;


    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/keywords")
    public String getText(@RequestBody String text){
        content =text;
        return text;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @RequestMapping("/keywords")
    public ResultsContent sendDetected() throws Exception{
        if (content==null){
            System.out.println("******content is null********");
        }else {
            return DetectSensitiveKeywords.detect(content);
        }

        return null;
    }
}