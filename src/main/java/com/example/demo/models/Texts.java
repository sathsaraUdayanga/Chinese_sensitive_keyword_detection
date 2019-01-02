package com.example.demo.models;

public class Texts {
    private int id;
    private String text;
    private int length;

    public Texts(int id, String text, int length){
        this.id = id;
        this.text = text;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}