package org.mixtream.mixtreamwebapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Album {
    String title;
    String description;
    List<Track> trackList;
}
