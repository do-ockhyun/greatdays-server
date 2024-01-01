package com.misolab.greatdays.gpt;

import lombok.Data;

@Data
public class FeedbackResult {
    private String title;
    private String feedback;
    private String keyword;
    private String point;
}