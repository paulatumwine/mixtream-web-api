package org.mixtream.mixtreamwebapi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Data
public class PlayDTO {
    String id;
    @NotNull
    LocalDateTime playTime;
    @NotNull
    TrackDTO track;
    @NotNull
    UserDTO user;
}