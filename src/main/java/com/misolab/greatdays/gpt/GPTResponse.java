package com.misolab.greatdays.gpt;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GPTResponse {
    private List<Choice> choices;
    
    @Data

    @NoArgsConstructor
    public static class Choice {
        private int index;
        private Message message;
    }

    String getContent() {
        if (choices == null || choices.isEmpty()) {
            return "";
        }
        return choices.get(0).getMessage().getContent();
    }
}
