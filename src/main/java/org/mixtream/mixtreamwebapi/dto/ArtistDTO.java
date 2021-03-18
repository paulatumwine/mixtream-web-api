package org.mixtream.mixtreamwebapi.dto;

import lombok.Builder;
import lombok.Data;
import org.mixtream.mixtreamwebapi.model.Track;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Builder
@Data
public class ArtistDTO {
    String id;
    @NotBlank
    String name;
    String link;
}
