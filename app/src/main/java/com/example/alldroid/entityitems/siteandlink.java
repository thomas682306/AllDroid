package com.example.alldroid.entityitems;

public class siteandlink {
    private String sitename,link;

    public siteandlink() {
    }

    public siteandlink(String sitename, String link) {
        this.sitename = sitename;
        this.link = link;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
