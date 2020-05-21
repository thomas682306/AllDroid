package com.example.alldroid.MapPackage;

public class MapModel {
    private String status_text;
    private int status_drawable;
    private boolean isWebView;
    private int item_number;
    private String url;

    public boolean isWebView() {
        return isWebView;
    }

    public int getItem_number() {
        return item_number;
    }

    public void setItem_number(int item_number) {
        this.item_number = item_number;
    }

    public void setWebView(boolean webView) {
        isWebView = webView;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MapModel() {
    }

    public MapModel(String status_text, int status_drawable, boolean isWebView, int item_number, String url) {
        this.status_text = status_text;
        this.status_drawable = status_drawable;
        this.isWebView = isWebView;
        this.item_number = item_number;
        this.url = url;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }

    public int getStatus_drawable() {
        return status_drawable;
    }

    public void setStatus_drawable(int status_drawable) {
        this.status_drawable = status_drawable;
    }

}
