package org.mixtream.mixtreamwebapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Track {
    String title;
    String description;
    String path;
    Artist artist;
}
