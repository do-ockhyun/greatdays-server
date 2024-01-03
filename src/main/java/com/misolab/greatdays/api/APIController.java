package com.misolab.greatdays.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.misolab.greatdays.gpt.FeedbackResult;
import com.misolab.greatdays.gpt.GPTService;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    GPTService gptService;

    @GetMapping()
    public String index() {
        return "Hello, world!";
    }

    @PostMapping("/feedback")
    public FeedbackResult feedback(@RequestBody String content) throws Exception {
        FeedbackResult result = gptService.chat(content);
        return result;
    }

    @GetMapping("/diary/${yyyymm}")
    public String diary(String yyyymm) {
        return "Hello, world!";
    }

    @GetMapping("/chat/${yyyymmdd}")
    public String chat(String yyyymmdd) {
        return "Hello, world!";
    }

    @PostMapping("/save/${saveID}")
    public String save(String saveID) {
        return "Hello, world!";
    }
    
}
