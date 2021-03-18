package org.mixtream.mixtreamwebapi.dto;

import lombok.Builder;
import lombok.Data;
import org.mixtream.mixtreamwebapi.model.Artist;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class TrackDTO {
    String id;
    @NotBlank
    String title;
    String description;
    @NotBlank
    String path;
    @NotNull
    Artist artist;
}
