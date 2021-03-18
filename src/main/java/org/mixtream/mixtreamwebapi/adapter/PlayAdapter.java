package org.mixtream.mixtreamwebapi.adapter;

import org.mixtream.mixtreamwebapi.dto.PlayDTO;
import org.mixtream.mixtreamwebapi.model.Play;

public class PlayAdapter {

    public static Play getPlay(PlayDTO obj) {
        return Play.builder()
                .id(obj.getId())
                .playTime(obj.getPlayTime())
                .track(TrackAdapter.getTrack(obj.getTrack()))
                .user(UserAdapter.getUser(obj.getUser()))
                .build();
    }

    public static PlayDTO getPlayDTO(Play obj) {
        return obj == null ? PlayDTO.builder().build() : PlayDTO.builder()
                .id(obj.getId())
                .playTime(obj.getPlayTime())
                .track(TrackAdapter.getTrackDTO(obj.getTrack()))
                .user(UserAdapter.getUserDTO(obj.getUser()))
                .build();
    }
}
