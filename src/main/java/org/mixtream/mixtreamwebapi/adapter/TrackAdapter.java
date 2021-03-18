package org.mixtream.mixtreamwebapi.adapter;

import org.mixtream.mixtreamwebapi.dto.TrackDTO;
import org.mixtream.mixtreamwebapi.model.Track;

public class TrackAdapter {

    public static Track getTrack(TrackDTO obj) {
        return Track.builder()
                .id(obj.getId())
                .title(obj.getTitle())
                .description(obj.getDescription())
                .path(obj.getPath())
                .artist(obj.getArtist())
                .build();
    }

    public static TrackDTO getTrackDTO(Track obj) {
        return obj == null ? TrackDTO.builder().build() : TrackDTO.builder()
                .id(obj.getId())
                .title(obj.getTitle())
                .description(obj.getDescription())
                .path(obj.getPath())
                .artist(obj.getArtist())
                .build();
    }
}
