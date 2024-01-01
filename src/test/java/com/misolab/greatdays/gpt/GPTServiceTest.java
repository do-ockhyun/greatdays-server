package com.misolab.greatdays.gpt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class GPTServiceTest {

    @Autowired
    GPTService gptService;

    @Test
    void testChat() throws Exception {
        FeedbackResult response = gptService.chat("가족과 함께 저녁을 먹고 볼링장을 갔다. 예나는 볼링공이 자꾸 삐뚤어져서 잘 안굴러가서 화가 났다.");
        log.info("response: {}", response);
        assertNotNull(response);
    }
}