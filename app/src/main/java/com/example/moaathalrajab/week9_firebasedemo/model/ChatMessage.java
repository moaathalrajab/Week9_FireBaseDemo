package com.example.moaathalrajab.week9_firebasedemo.model;

/**
 * Created by m_alrajab on 4/3/17.
 */

public class ChatMessage {
    private String msg;
    private String username;


    public ChatMessage(){

    }
    public ChatMessage(String msg, String username) {
        this.msg = msg;
        this.username = username;
    }



    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }




    public void setUsername(String username) {
        this.username = username;
    }
}
