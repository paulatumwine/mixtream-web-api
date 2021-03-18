package org.mixtream.mixtreamwebapi.adapter;

import org.mixtream.mixtreamwebapi.dto.AlbumDTO;
import org.mixtream.mixtreamwebapi.dto.ArtistDTO;
import org.mixtream.mixtreamwebapi.model.Album;
import org.mixtream.mixtreamwebapi.model.Artist;

public class ArtistAdapter {

    public static Artist getArtist(ArtistDTO obj) {
        return Artist.builder()
                .id(obj.getId())
                .name(obj.getName())
                .link(obj.getLink())
                .build();
    }

    public static ArtistDTO getArtistDTO(Artist obj) {
        return obj == null ? ArtistDTO.builder().build() : ArtistDTO.builder()
                .id(obj.getId())
                .name(obj.getName())
                .link(obj.getLink())
                .build();
    }
}
