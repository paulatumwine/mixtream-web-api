package org.mixtream.mixtreamwebapi.service;

import org.mixtream.mixtreamwebapi.adapter.PlaylistAdapter;
import org.mixtream.mixtreamwebapi.dto.PlaylistDTO;
import org.mixtream.mixtreamwebapi.model.Playlist;
import org.mixtream.mixtreamwebapi.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    @Autowired
    PlaylistRepository repository;

    public List<PlaylistDTO> findAll() {
        List<Playlist> list = repository.findAll();
        return list.stream().map(PlaylistAdapter::getPlaylistDTO).collect(Collectors.toList());
    }

    public PlaylistDTO findById(String id) {
        Playlist obj = repository.findById(id).orElse(null);
        return PlaylistAdapter.getPlaylistDTO(obj);
    }

    public PlaylistDTO save(PlaylistDTO request) {
        Playlist response = repository.save(PlaylistAdapter.getPlaylist(request));
        return PlaylistAdapter.getPlaylistDTO(response);
    }

    public PlaylistDTO update(PlaylistDTO request) {
        Playlist response = repository.save(PlaylistAdapter.getPlaylist(request));
        return PlaylistAdapter.getPlaylistDTO(response);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
