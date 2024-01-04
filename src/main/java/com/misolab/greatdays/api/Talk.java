package com.misolab.greatdays.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Talk {
    String sender;
    String created;
    String content;
}
