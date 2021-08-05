package com.example.messengerr;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chatbot {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response")
    @Expose
    private String response;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}