package com.misolab.greatdays.gpt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResult {
    private String feedback;
    private String keyword;
    private int point;
    private String language;
}