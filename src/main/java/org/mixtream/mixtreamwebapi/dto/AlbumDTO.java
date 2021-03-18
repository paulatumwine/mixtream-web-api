package org.mixtream.mixtreamwebapi.dto;

import lombok.Builder;
import lombok.Data;
import org.mixtream.mixtreamwebapi.model.Track;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Builder
@Data
public class AlbumDTO {
    Integer id;
    @NotBlank
    String title;
    String description;
    List<Track> trackList;
}
