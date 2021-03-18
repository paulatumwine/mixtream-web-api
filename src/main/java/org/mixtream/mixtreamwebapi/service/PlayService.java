package org.mixtream.mixtreamwebapi.service;

import org.mixtream.mixtreamwebapi.adapter.PlayAdapter;
import org.mixtream.mixtreamwebapi.dto.PlayDTO;
import org.mixtream.mixtreamwebapi.model.Play;
import org.mixtream.mixtreamwebapi.repository.PlayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayService {

    @Autowired
    PlayRepository repository;

    public List<PlayDTO> findAll() {
        List<Play> list = repository.findAll();
        return list.stream().map(PlayAdapter::getPlayDTO).collect(Collectors.toList());
    }

    public PlayDTO findById(String id) {
        Play obj = repository.findById(id).orElse(null);
        return PlayAdapter.getPlayDTO(obj);
    }

    public PlayDTO save(PlayDTO request) {
        Play response = repository.save(PlayAdapter.getPlay(request));
        return PlayAdapter.getPlayDTO(response);
    }

    public PlayDTO update(PlayDTO request) {
        Play response = repository.save(PlayAdapter.getPlay(request));
        return PlayAdapter.getPlayDTO(response);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
