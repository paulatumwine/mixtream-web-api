package org.mixtream.mixtreamwebapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Artist {
    @Id
    Integer id;
    String name;
    String link;
}
