package org.mixtream.mixtreamwebapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Data
@Document
public class Play {
    @Id
    String id;
    LocalDateTime playTime;
    Track track;
    User user;
}
