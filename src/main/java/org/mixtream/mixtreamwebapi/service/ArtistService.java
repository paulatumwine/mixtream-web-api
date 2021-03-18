package org.mixtream.mixtreamwebapi.service;

import org.mixtream.mixtreamwebapi.adapter.ArtistAdapter;
import org.mixtream.mixtreamwebapi.dto.ArtistDTO;
import org.mixtream.mixtreamwebapi.model.Artist;
import org.mixtream.mixtreamwebapi.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    @Autowired
    ArtistRepository repository;

    public List<ArtistDTO> findAll() {
        List<Artist> list = repository.findAll();
        return list.stream().map(ArtistAdapter::getArtistDTO).collect(Collectors.toList());
    }

    public ArtistDTO findById(String id) {
        Artist obj = repository.findById(id).orElse(null);
        return ArtistAdapter.getArtistDTO(obj);
    }

    public ArtistDTO save(ArtistDTO request) {
        Artist response = repository.save(ArtistAdapter.getArtist(request));
        return ArtistAdapter.getArtistDTO(response);
    }

    public ArtistDTO update(ArtistDTO request) {
        Artist response = repository.save(ArtistAdapter.getArtist(request));
        return ArtistAdapter.getArtistDTO(response);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
