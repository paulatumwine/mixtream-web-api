package org.mixtream.mixtreamwebapi.dto;

import lombok.Builder;
import lombok.Data;
import org.mixtream.mixtreamwebapi.model.Track;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Builder
@Data
public class PlaylistDTO {
    String id;
    @NotBlank
    String title;
    String description;
    List<Track> trackList;
}
