package com.example.ceval.beastexample1.views.RushViews;

import com.example.ceval.beastexample1.entites.RushEvent;

import java.util.List;

public class Item {
    public int type;
    public String test;
    public RushEvent rushEvent;
    public List<Item> invisibleChildrlen;


    public Item(int type, RushEvent rushEvent) {
        this.type = type;
        this.rushEvent = rushEvent;
    }

    public Item(int type,String test) {
        this.test = test;
        this.type = type;
    }
}
