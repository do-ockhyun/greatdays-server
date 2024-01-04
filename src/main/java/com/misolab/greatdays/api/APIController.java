package com.misolab.greatdays.api;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/feedback/{roomID}")
    public FeedbackResult feedback(@PathVariable("roomID") String roomID,
            @RequestBody ArrayList<Talk> talks) throws Exception {
        String content = talks.stream()
                .map(t -> t.getContent())
                .reduce((a, b) -> a + "\n" + b)
                .orElseThrow();
        //  TODO: save content to DB

        FeedbackResult result = gptService.chat(content);
        //  TODO: save feedback to DB
        
        return result;
    }

    @GetMapping("/diary/{yyyymm}")
    public String diary(String yyyymm) {
        return "Hello, world!";
    }

    @GetMapping("/chat/{yyyymmdd}/{roomID}")
    public ChatDto chat(@PathVariable("yyyymmdd") String yyyymmdd, @PathVariable("roomID") String roomID) {
        ChatDto chatDto = new ChatDto();

        Talk talk = new Talk("bot", "2021-01-01 00:00:00", "What's Great Happening?");

        if (roomID.equals("new")) {
            chatDto.setRoomId("100");
            chatDto.setTalks(Arrays.asList(talk));
            return chatDto;
        }

        Talk talk1 = new Talk("me", "2021-08-01T00:00:00.000Z", "敢えて特別になるために");
        Talk talk2 = new Talk("me", "2021-08-01T00:00:00.000Z", "頑張らない瞬間から");
        Talk talk3 = new Talk("me", "2021-08-01T00:00:00.000Z", "人生は少しずつ私のものになる");

        chatDto.setRoomId(roomID);
        chatDto.setTalks(Arrays.asList(talk, talk1, talk2, talk3));
        return chatDto;
    }

    @PostMapping("/save/{saveID}")
    public String save(String saveID) {
        return "Hello, world!";
    }

}
