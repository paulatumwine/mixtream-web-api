package org.mixtream.mixtreamwebapi.adapter;

import org.mixtream.mixtreamwebapi.dto.PlaylistDTO;
import org.mixtream.mixtreamwebapi.model.Playlist;

public class PlaylistAdapter {

    public static Playlist getPlaylist(PlaylistDTO obj) {
        return Playlist.builder()
                .id(obj.getId())
                .title(obj.getTitle())
                .description(obj.getDescription())
                .trackList(obj.getTrackList())
                .build();
    }

    public static PlaylistDTO getPlaylistDTO(Playlist obj) {
        return obj == null ? PlaylistDTO.builder().build() : PlaylistDTO.builder()
                .id(obj.getId())
                .title(obj.getTitle())
                .description(obj.getDescription())
                .trackList(obj.getTrackList())
                .build();
    }
}
