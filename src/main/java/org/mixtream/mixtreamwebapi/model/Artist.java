package org.mixtream.mixtreamwebapi.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document
public class Artist {
    @Id
    String id;
    String name;
    String link;
}
