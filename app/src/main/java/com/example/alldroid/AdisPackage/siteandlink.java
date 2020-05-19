package com.example.alldroid.AdisPackage;

import java.io.Serializable;

public class siteandlink implements Serializable {
    private String Sitename,link;

    public siteandlink() {
    }

    public siteandlink(String Sitename, String link) {
        this.Sitename = Sitename;
        this.link = link;
    }

    public String getSitename() {
        return Sitename;
    }

    public void setSitename(String Sitename) {
        this.Sitename = Sitename;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
