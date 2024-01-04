package com.misolab.greatdays.api;

import java.util.List;

import lombok.Data;

@Data
public class ChatDto {
    String roomId;
    List<Talk> talks;
}
