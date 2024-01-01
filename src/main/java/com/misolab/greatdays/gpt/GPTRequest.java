package com.misolab.greatdays.gpt;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GPTRequest {
    private String model;
    private double temperature;
    private int max_tokens;

    private List<Message> messages;
    
    public GPTRequest(String model, double temperature, int max_tokens) {
        this.model = model;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
    }

    public void addMessage(String role, String content) {
        if (messages == null) {
            messages = new ArrayList<>();
        }
        messages.add(new Message(role, content));
    }

}
