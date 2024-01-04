package com.misolab.greatdays.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.misolab.greatdays.gpt.FeedbackResult;

import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class APIControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void testChat() {
        String url = "http://localhost:" + port + "/api/chat/20210101";
        ResponseEntity<ChatDto> response = restTemplate.getForEntity(url, ChatDto.class);
        log.info("response: {}", response);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getClass()).isEqualTo(ChatDto.class);
    }

    @Test
    void testFeedback() {
        String url = "http://localhost:" + port + "/api/feedback/20210101";
        Talk talk1 = new Talk("me", "2021-08-01T00:00:00.000Z", "敢えて特別になるために");
        Talk talk2 = new Talk("me", "2021-08-01T00:00:00.000Z", "頑張らない瞬間から");
        Talk talk3 = new Talk("me", "2021-08-01T00:00:00.000Z", "人生は少しずつ私のものになる");
        List<Talk> talk = Arrays.asList(talk1, talk2, talk3);
        ResponseEntity<FeedbackResult> response = restTemplate.postForEntity(url, talk, FeedbackResult.class);
        log.info("response: {}", response);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getFeedback()).isNotNull();
    }

    // @Test
    // void testDiary() {

    // }

    // @Test
    // void testIndex() {

    // }

    // @Test
    // void testSave() {

    // }
}
