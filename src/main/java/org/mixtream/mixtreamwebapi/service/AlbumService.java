package org.mixtream.mixtreamwebapi.service;

import org.mixtream.mixtreamwebapi.adapter.AlbumAdapter;
import org.mixtream.mixtreamwebapi.dto.AlbumDTO;
import org.mixtream.mixtreamwebapi.model.Album;
import org.mixtream.mixtreamwebapi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    @Autowired
    AlbumRepository repository;

    public List<AlbumDTO> findAll() {
        List<Album> albumList = repository.findAll();
        return albumList.stream().map(AlbumAdapter::getAlbumDTO).collect(Collectors.toList());
    }

    public AlbumDTO findById(String id) {
        Album album = repository.findById(id).orElse(null);
        return AlbumAdapter.getAlbumDTO(album);
    }

    public AlbumDTO save(AlbumDTO request) {
        Album response = repository.save(AlbumAdapter.getAlbum(request));
        return AlbumAdapter.getAlbumDTO(response);
    }

    public AlbumDTO update(AlbumDTO request) {
        Album response = repository.save(AlbumAdapter.getAlbum(request));
        return AlbumAdapter.getAlbumDTO(response);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
