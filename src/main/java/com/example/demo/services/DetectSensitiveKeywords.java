package com.example.demo.services;

import com.example.demo.controller.AppController;
import com.example.demo.models.Texts;

import javax.xml.soap.Text;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DetectSensitiveKeywords {

    public static List<Texts> detect(String content) throws Exception{

        //Read keywords............................................................................
        List<String> keywords=new ArrayList<String>();
        List<Texts> dertectedList=new ArrayList<>();

        File file = new File("D:\\Sinobis\\prototype\\chinesesensitivekeworddetection\\src\\main\\resources\\word-list\\keywords\\keywords.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UNICODE"));
        String st;
        while ((st = br.readLine()) != null) {
            keywords.add(st);
        }



        //Read text................................................................................
        InputStream is = new FileInputStream("D:\\Sinobis\\prototype\\chinesesensitivekeworddetection\\src\\main\\resources\\word-list\\keywords\\text-2.txt");
        BufferedReader buf = new BufferedReader(new InputStreamReader(is , "UNICODE"));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null){
            sb.append(line).append("\n"); line = buf.readLine();
        }
        String text = sb.toString();


        //Regular Expressions..............................................
        for(String s:keywords){
            Pattern pattern = Pattern.compile(s);
            //Matcher m = pattern.matcher(text);
            Matcher m = pattern.matcher(content);
            while (m.find()) {
                Texts t = new Texts(m.start(),m.pattern().toString(), m.pattern().toString().length());
                dertectedList.add(t);
            }
        }
        System.out.println("Detecte Sensitive Keywords... Executed...");
        return dertectedList;
    }


}