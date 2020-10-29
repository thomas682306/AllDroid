package com.example.alldroid.AdisPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class topic implements Serializable {
    private String Topic,Description;


    public topic() {
    }

    public topic(String topic, String description) {
        Topic = topic;
        Description = description;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
