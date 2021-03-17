package org.mixtream.mixtreamwebapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Play {
    LocalDateTime playTime;
    Track track;
    User user;
}
