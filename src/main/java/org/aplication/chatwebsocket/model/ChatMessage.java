package org.aplication.chatwebsocket.model;

public class ChatMessage {
    private String from;
    private String text;

    public ChatMessage(){}

    public ChatMessage(String from, String text){
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
