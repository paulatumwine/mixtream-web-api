package org.mixtream.mixtreamwebapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Artist {
    String name;
    String link;
}
