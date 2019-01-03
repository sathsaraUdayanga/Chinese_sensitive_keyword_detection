package com.example.demo.services;

import com.example.demo.models.ResultsContent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetectSensitiveKeywords {

    public static ResultsContent detect(String content) throws Exception{

        //Read keywords............................................................................
        List<String> keywords=new ArrayList<String>();
        List<String> detectedList=new ArrayList<>();
        String resultHtmlContent = content;

        File file = new File("D:\\Sinobis\\prototype\\chinesesensitivekeworddetection\\src\\main\\resources\\word-list\\keywords\\keywords.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UNICODE"));
        String st;
        while ((st = br.readLine()) != null) {
            keywords.add(st);
        }


        //Regular Expressions..............................................
        String replaceText;
        long startTime3 = System.nanoTime(); //Start timer
        for(String s:keywords){
            Pattern pattern = Pattern.compile(s);
            Matcher m = pattern.matcher(content);
            while (m.find()) {
                detectedList.add(m.pattern().toString());
                replaceText = "<span class=\"highlight\">"+m.pattern().toString()+"</span>";
                resultHtmlContent = m.replaceAll(replaceText);
                content = m.replaceAll(replaceText);
            }
        }
        long endTime3 = System.nanoTime(); // Stop timer

        System.out.println("Search time: "+(endTime3 - startTime3)/1000000+" milliseconds");

        return new ResultsContent(resultHtmlContent,detectedList,detectedList.size());
    }

}