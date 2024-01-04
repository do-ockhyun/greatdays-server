package com.misolab.greatdays.gpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GPTService {
    
    @Qualifier("openaiRestTemplate")
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${openai.api.url}")
    private String apiUrl;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.temperature}")
    private double temperature;

    @Value("${openai.max_tokens}")
    private int max_tokens;

    public FeedbackResult chat(String events) throws Exception {
        String userPrompt = """
1. understanding the [events] separated by --- at the bottom.
2. [Feedback] should include positive responses such as encouragement and congratulations.
3. [Keyword] Specify keywords from the diary content.
4. [Point] Assign an emotional score between 1 and 10 based on the content.
5. [Language] Please use the same language as [events] for [Feedback]
6. write in the following format.

Use the output in the following JSON format:
{ 
    feedback: here is [Feedback],
    keyword: here is [Keyword],
    point: here is [Point],
    language: here is [Language]
}

[events]:
---
%s
""".formatted(events);

        GPTRequest request = new GPTRequest(model, temperature, max_tokens);
        request.addMessage("system", "You are a mentor who provides support based on reading a diary. Proceed in the following order.");
        request.addMessage("user", userPrompt);

        GPTResponse response = restTemplate.postForObject(apiUrl, request, GPTResponse.class);
        log.info("{}", response.getContent());

        ObjectMapper mapper = new ObjectMapper();
        FeedbackResult result = mapper.readValue(response.getContent(), FeedbackResult.class);
        return result;
    }

}
