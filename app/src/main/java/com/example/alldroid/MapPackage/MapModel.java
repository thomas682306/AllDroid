package com.example.alldroid.MapPackage;

public class MapModel {
    private String status_text;
    private int status_drawable;
    private boolean isWebView;
    private String url;

    public boolean isWebView() {
        return isWebView;
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

    public MapModel(String status_text, int status_drawable, boolean isWebView, String url) {
        this.status_text = status_text;
        this.status_drawable = status_drawable;
        this.isWebView = isWebView;
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
