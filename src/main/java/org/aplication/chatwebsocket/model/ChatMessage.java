package org.aplication.chatwebsocket.model;


import org.aplication.chatwebsocket.util.DateTimeUtils;

import java.time.Instant;

public class
ChatMessage {
    private String from;
    private String text;
    private Instant time;

    public ChatMessage(){}

    public ChatMessage(String from, String text, Instant time){
        this.from = from;
        this.text = text;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }

    public String getTime(){
        return DateTimeUtils.formatToSeconds(time);
    }
}
