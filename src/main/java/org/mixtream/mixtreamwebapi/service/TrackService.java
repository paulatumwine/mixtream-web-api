package org.mixtream.mixtreamwebapi.service;

import org.mixtream.mixtreamwebapi.adapter.TrackAdapter;
import org.mixtream.mixtreamwebapi.dto.TrackDTO;
import org.mixtream.mixtreamwebapi.model.Track;
import org.mixtream.mixtreamwebapi.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackService {

    @Autowired
    TrackRepository repository;

    public List<TrackDTO> findAll() {
        List<Track> list = repository.findAll();
        return list.stream().map(TrackAdapter::getTrackDTO).collect(Collectors.toList());
    }

    public TrackDTO findById(String id) {
        Track obj = repository.findById(id).orElse(null);
        return TrackAdapter.getTrackDTO(obj);
    }

    public TrackDTO save(TrackDTO request) {
        Track response = repository.save(TrackAdapter.getTrack(request));
        return TrackAdapter.getTrackDTO(response);
    }

    public TrackDTO update(TrackDTO request) {
        Track response = repository.save(TrackAdapter.getTrack(request));
        return TrackAdapter.getTrackDTO(response);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
