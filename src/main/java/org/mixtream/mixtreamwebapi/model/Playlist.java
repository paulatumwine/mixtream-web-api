package org.mixtream.mixtreamwebapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Playlist {
    @Id
    Integer id;
    String title;
    String description;
    List<Track> trackList;
}