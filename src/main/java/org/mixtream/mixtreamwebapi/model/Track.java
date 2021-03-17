package org.mixtream.mixtreamwebapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Track {
    @Id
    Integer id;
    String title;
    String description;
    String path;
    Artist artist;
}
