package org.mixtream.mixtreamwebapi.adapter;

import org.mixtream.mixtreamwebapi.dto.AlbumDTO;
import org.mixtream.mixtreamwebapi.model.Album;

public class AlbumAdapter {

    public static Album getAlbum(AlbumDTO obj) {
        return Album.builder()
                .id(obj.getId())
                .title(obj.getTitle())
                .description(obj.getDescription())
                .trackList(obj.getTrackList())
                .build();
    }

    public static AlbumDTO getAlbumDTO(Album obj) {
        return obj == null ? AlbumDTO.builder().build() : AlbumDTO.builder()
                .id(obj.getId())
                .title(obj.getTitle())
                .description(obj.getDescription())
                .trackList(obj.getTrackList())
                .build();
    }
}
