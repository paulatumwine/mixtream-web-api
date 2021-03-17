package org.mixtream.mixtreamwebapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Play {
    @Id
    Integer id;
    LocalDateTime playTime;
    Track track;
    User user;
}
