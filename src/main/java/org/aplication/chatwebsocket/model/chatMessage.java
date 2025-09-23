package org.aplication.chatwebsocket.model;

public class chatMessage {
    private String from;
    private String text;

    public chatMessage(){}

    public chatMessage(String from, String text){
        this.from = from;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }
}
