package com.example.recyclerapp.ui.model;

import com.example.recyclerapp.common.recycler.delegate.DelegateItem;

public class Title implements DelegateItem {

    private String text;

    public Title(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String id() {
        return text;
    }

    @Override
    public String content() {
        return text;
    }
}
