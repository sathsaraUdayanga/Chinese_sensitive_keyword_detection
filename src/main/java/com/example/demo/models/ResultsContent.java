package com.example.demo.models;

import java.util.List;

public class ResultsContent {

    private String htmlContent;
    private int found;
    private List<String> keywords;

    public ResultsContent(String htmlContent, List<String> keywords, int found){
        this.htmlContent = htmlContent;
        this.keywords = keywords;
        this.found = found;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }
}